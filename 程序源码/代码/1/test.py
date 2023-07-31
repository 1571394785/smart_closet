import machine,time
light=machine.Pin(2, machine.Pin.OUT)
# hall = machine.Pin(2, machine.Pin.IN, machine.Pin.PULL_UP)
while True:
    light.value(1)
    time.sleep(1)
    light.value(0)
    time.sleep(1)