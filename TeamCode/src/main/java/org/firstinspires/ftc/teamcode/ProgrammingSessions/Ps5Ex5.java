package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ProgrammingSessions.Motor;

@TeleOp
@Disabled

public class Ps5Ex5 extends OpMode {

    double mass = 10.0;

    Motor motor1 = new Motor();
    Motor motor2 = new Motor();
    Motor motor3 = new Motor();
    Motor motor4 = new Motor();

    @Override
    public void init()
    {
        motor1.velocity = 5.0;
        motor1.torque(motor1.velocity, mass);

        motor2.velocity = 5.0;
        motor2.torque(motor2.velocity, mass);

        motor3.velocity = 5.0;
        motor3.torque(motor3.velocity, mass);

        motor4.velocity = 5.0;
        motor4.torque(motor4.velocity, mass);
    }
    @Override
    public void loop()
    {

    }
}
