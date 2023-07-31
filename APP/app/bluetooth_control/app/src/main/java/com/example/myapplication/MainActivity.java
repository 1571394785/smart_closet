package com.example.myapplication;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    BluetoothSocket socket = null;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        is_premission();
        Log.d("蓝牙接收", "onCreate: ");
        SeekBar mySeekBar = findViewById(R.id.seekBar);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                if (socket != null) {
                    try {
//                      将0-100转为20-50
                        int value = (int) (progress * 0.3 + 20);
                        send_data(String.valueOf(value) + "\r\n");
                        findViewById(R.id.textView2).post(new Runnable() {
                            @Override
                            public void run() {
                                TextView tv = findViewById(R.id.textView2);
                                tv.setText("设定温度：" + value);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(MainActivity.this, "开始拖动", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //  新建bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
//              打开新activity
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, 1);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Connect_To_Bluetooth(String mac) {
        BluetoothDevice device = null;
        device = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(mac);
//                  连接蓝牙
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            socket.connect();
            Toast.makeText(this, "连接成功", Toast.LENGTH_SHORT).show();
//          多线程启动蓝牙接收
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String[] data = new String[0];
                            byte[] buffer = new byte[1024];
//                          判断缓冲区是否有数据
                            if (socket.getInputStream().available() > 0) {
                                Thread.sleep(100);
//                              缓冲区字节长度
                                int len = socket.getInputStream().read(buffer);
                                socket.getInputStream().read(buffer, 0, len);
                                String str = new String(buffer, "utf-8");
                                data= str.split(" ");
                            }
                            String[] finalData = data;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    TextView temp = findViewById(R.id.temp);
                                    TextView hum= findViewById(R.id.hum);
                                    TextView led = findViewById(R.id.led);
                                    TextView jidianqi = findViewById(R.id.jidianqi);
                                    try {
                                        temp.setText(finalData[0]);
                                        hum.setText(finalData[1]);
                                        jidianqi.setText(finalData[2]);
                                        led.setText(finalData[3]);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "连接失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            String mac = data.getStringExtra("mac");
            Toast.makeText(this, mac, Toast.LENGTH_SHORT).show();
            Connect_To_Bluetooth(mac);
        }
    }

    //  判断蓝牙权限是否开启
    @RequiresApi(api = Build.VERSION_CODES.S)
    void is_premission() {
        ActivityResultLauncher<String> mPermissionResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your app.
            } else {
                // Explain to the user that the feature is unavailable because the features requires a permission that the user has denied.
            }
        });
        mPermissionResult.launch(android.Manifest.permission.BLUETOOTH);
        mPermissionResult.launch(android.Manifest.permission.BLUETOOTH_ADMIN);
        mPermissionResult.launch(android.Manifest.permission.ACCESS_FINE_LOCATION);
        mPermissionResult.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        mPermissionResult.launch(android.Manifest.permission.BLUETOOTH_CONNECT);
    }

    //   蓝牙，将发送文本转byte
    void send_data(String data) {
        byte[] bytes = data.getBytes();
        try {
            socket.getOutputStream().write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}