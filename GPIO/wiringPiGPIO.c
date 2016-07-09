#include <wiringPi.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
//http://wiringpi.com/pins/special-pin-functions/
/*
WiringPi defines 17 pins, (21 on a Rev. 2 board) but some of them and the functions we can use may potentially cause problems with other parts of the Raspberry Pi Linux system.

    Pins 0 through 6 (BCM_GPIO 17, 18,  21, 22, 23, 24, 25 respectively, substitute 27 for 21 on a Rev. 2 board): These are safe to use at any time and can be set to input or output with or without the internal pull-up or pull-down resistors enabled.
    Pin 7 (BCM_GPIO 4) This is normally OK to use, however it is used by the 1-Wire kernel driver and it can optionally be connected to a GPIO clock source.

    PWM: You can change the function of pin 1 (BCM_GPIPO 18) to be PWM output, however if you are currently playing music or using the audio system via the 3.5mm jack socket, then youâ€™ll find one channel of audio PWM coming through the pin! If you are not using the audio at all, (or the audio is going via the HDMI cable), then this pin is free to be used in PWM mode.

    Pins 8 and 9 (BCM GPIO 0 and 1 on a Rev. 1 board, 2 and 3 on a Rev. 2 board): These are the I2C pins. You may use them for digital IO if you are not using any I2C drivers which use these pins, however note that they have on-board 1.8KÎ© resistors pulling the signals to the 3v3 supply. This feature does make them handy for switch inputs where the switch simply shorts the pin to ground without having to enable the internal pull-up resistors

    Pins 10, 11, 12, 13 and 14 (GPIO 8, 7, 10, 9 and 11 respectively): These are used for the SPI interface. Like the I2C interface, if you are not using it, then you can freely use them for your own purposes. Unlike I2C, these pins do not have any external pull up (or pull down) resistors.

    Pins 15 and 16 (GPIO 14 and 15): These are used by the UART for Tx and Rx respectively. If you want to use these pins as general purpose I/O pins then you need to make sure that you reboot your Pi with the serial console disabled. See the file /boot/cmdline.txt and edit it appropriately.

    Pins 17, 18, 19 and 20: (BCM_GPIO 28, 29, 30 and 31) These are additional GPIO pins on the Rev. 2 board.

*/
#define SWITCH1 0 /* = 17,  !< Version 2, Pin P1-11 */
#define SWITCH2 1 /* = 18,  !< Version 2, Pin P1-12, can be PWM channel 0 in ALT FUN 5 */
#define SWITCH3 2 /* = 27,  !< Version 2, Pin P1-13 */
#define SWITCH4 3 /* = 22,  !< Version 2, Pin P1-15 */
#define SWITCH5 4 /* = 23,  !< Version 2, Pin P1-16 */
#define SWITCH6 5 /* = 24,  !< Version 2, Pin P1-18 */
#define SWITCH7 6 /* = 25,  !< Version 1, Pin P1-22 */

int main (int argc, char *argv[])
{
	wiringPiSetup () ;  
	char *switchNo = argv[1];
	char *on = argv[2];
	if(NULL == switchNo || NULL == on)
	{
		return -1 ;
	}
	else
	{	
		if(0 == strcmp("ON",on))
		{
			if(0 == strcmp(switchNo,"1"))	
			{
				pinMode(SWITCH1, OUTPUT);		
				digitalWrite(SWITCH1, HIGH);
			}
			else if(0 == strcmp(switchNo,"2"))	
			{
				pinMode(SWITCH2, OUTPUT);		
				digitalWrite(SWITCH2, HIGH);
			}
			else if(0 == strcmp(switchNo,"3"))	
			{
				pinMode(SWITCH3, OUTPUT);		
				digitalWrite(SWITCH3, HIGH);
			}
			else if(0 == strcmp(switchNo,"4"))	
			{
				pinMode(SWITCH4, OUTPUT);		
				digitalWrite(SWITCH4, HIGH);
			}
			else if(0 == strcmp(switchNo,"5"))	
			{
				pinMode(SWITCH5, OUTPUT);		
				digitalWrite(SWITCH5, HIGH);
			}
			else if(0 == strcmp(switchNo,"6"))	
			{
				pinMode(SWITCH6, OUTPUT);		
				digitalWrite(SWITCH6, HIGH);
			}
			else if(0 == strcmp(switchNo,"7"))	
			{
				pinMode(SWITCH7, OUTPUT);		
				digitalWrite(SWITCH7, HIGH);
			}
		}
		else
		{
			if(0 == strcmp(switchNo,"1"))	
			{
				pinMode(SWITCH1, OUTPUT);		
				digitalWrite(SWITCH1, LOW);
			}
			else if(0 == strcmp(switchNo,"2"))	
			{
				pinMode(SWITCH2, OUTPUT);		
				digitalWrite(SWITCH2, LOW);
			}
			else if(0 == strcmp(switchNo,"3"))	
			{
				pinMode(SWITCH3, OUTPUT);		
				digitalWrite(SWITCH3, LOW);
			}
			else if(0 == strcmp(switchNo,"4"))	
			{
				pinMode(SWITCH4, OUTPUT);		
				digitalWrite(SWITCH4, LOW);
			}
			else if(0 == strcmp(switchNo,"5"))	
			{
				pinMode(SWITCH5, OUTPUT);		
				digitalWrite(SWITCH5, LOW);
			}
			else if(0 == strcmp(switchNo,"6"))	
			{
				pinMode(SWITCH6, OUTPUT);		
				digitalWrite(SWITCH6, LOW);
			}
			else if(0 == strcmp(switchNo,"7"))	
			{
				pinMode(SWITCH7, OUTPUT);		
				digitalWrite(SWITCH7, LOW);
			}
		}
	}
	return 0;  
}