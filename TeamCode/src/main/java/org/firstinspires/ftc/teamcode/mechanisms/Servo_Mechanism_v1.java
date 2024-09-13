package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Servo_Mechanism_v1 {

    private Servo servo = null;

    public void init(HardwareMap hwMap)
    {
        servo = hwMap.get(Servo.class, "servo0");

        servo.setDirection(Servo.Direction.FORWARD);

        servo.scaleRange(0.0, 1.0);

    }

    public void setPosition(double position)
    {
        servo.setPosition(position);
    }
}