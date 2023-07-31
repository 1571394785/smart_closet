import machine
import time
import ssd1306py as lcd
import network,socket
jidianqi = machine.Pin(13, machine.Pin.OUT)
key= machine.Pin(14, machine.Pin.IN, machine.Pin.PULL_UP)
led = machine.Pin(15, machine.Pin.OUT)
sensor_temp = machine.ADC(4) # Pico的温度传感器
conversion_factor = 3.3 / (65535)
set_temp_key = machine.ADC(0)
set_hum_key = machine.ADC(1)
board_led = machine.Pin(25, machine.Pin.OUT)
old_time=0
send_time=0
config=330
# 霍尔传感器
hall = machine.Pin(0, machine.Pin.IN, machine.Pin.PULL_UP)
# 设置中断
#hall.irq(trigger=machine.Pin.IRQ_RISING, handler=lambda t:print("上升沿触发"))
hall.irq(trigger=machine.Pin.IRQ_FALLING, handler=lambda t:open_light())
light=machine.Pin(2, machine.Pin.OUT)
# 初始化UART,使用4,5引脚，9600波特率
uart = machine.UART(1,baudrate=9600,rx=machine.Pin(5),tx=machine.Pin(4))
# 中断函数
def open_light():
    print("下降沿触发")
    light.value(1)
def open_jidianqi(flag):
    if flag == 0:
        jidianqi.value(1)
    else:
        jidianqi.value(0)
def open_led(flag):
    if flag == 0:
        led.value(0)
    else:
        led.value(1)
def read_temp():
    reading = sensor_temp.read_u16() * conversion_factor
    temperature = 27 - (reading - 0.706)/0.001721
    return temperature
def read_settemp():
    global config
    if set_temp_key.read_u16()>40000:
        config+=5
        time.sleep(0)
    elif set_temp_key.read_u16()<10000:
        config-=5
        time.sleep(0)
#读取湿度,返回值是
def read_hum():
    reading = sensor_temp.read_u16() * conversion_factor
    temperature = 27 - (reading - 0.706)/0.001721
    return temperature
def is_jidianqi_open():
    if jidianqi.value()==0:
        return "OPEN"
    else:
        return "CLOSE"
def is_led_open():
    if led.value()==1:
        return "OPEN"
    else:
        return "CLOSE"
# def init_i2c():
#     i2c = machine.I2C(0,scl=machine.Pin(21), sda=machine.Pin(20))
#     i2c.scan()
#     return i2c
# print(init_i2c())

lcd.init_i2c(21,20, 128, 64, 0)
open_led(False)
# lcd.text("Connect Network",0,0,16)
# lcd.show()
# wlan = network.WLAN(network.STA_IF)
# wlan.active(True)
# wlan.connect('GSWIFI', '18334234135')
# while not wlan.isconnected() and wlan.status()>0:
#     time.sleep(1)
# # 将IP地址显示在LCD上
# lcd.clear()
# lcd.text("IP:",0,0,16)
# lcd.text(wlan.ifconfig()[0],0,16,8)
# url=socket.getaddrinfo('bemfa.com', 8344)[0][-1]
# lcd.show()
# time.sleep(3)
while True:
    lcd.clear()
    temp=read_temp()
    hum=read_hum()
    lcd.text("Temp:" + str(temp),0,0,16)
    lcd.text("Target:"+str(config/10),0,16,16)
    lcd.text("heating:"+str(is_jidianqi_open()),0,32,16)
    lcd.text("Hum:"+str(hum)+"%",0,48,16)
    read_settemp()
    lcd.show()
    if key.value() == 0:
        open_led(True)
        old_time=time.time()
    if time.time()-old_time>10:
        open_led(False)
    if temp<config/10:
        open_jidianqi(True)
    else:
        open_jidianqi(False)
    # if abs(send_time-time.time())>30:
    #     board_led.value(1)
    #     send_time=time.time()
    #     try:
    #         s = socket.socket()
    #         data="cmd=2&uid=8df3e3423d4cd5e96c94460b41f912a0&topic=1004&msg=#"+str(int(temp))+"\r\n"
    #         print("connect",url,data)
    #         s.connect(url)
    #         s.send(data.encode())
    #         print("send")
    #     except Exception as e:
    #         print(e)
    #     board_led.value(0)
    # 霍尔高电平
    if hall.value()==1:
        light.value(0)
    # 串口发送
    uart.write(str(temp)+" "+str(hum)+" "+str(is_jidianqi_open())+" "+str(is_led_open())+" ")
    #串口接收
    if uart.any():
        x=str(uart.read())
        j=x.split("\\r\\n")
        # 取出最后一个
        x=j[len(j)-2]
        print(x)
        config=int(x)*10
    time.sleep(0)