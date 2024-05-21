package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@TeleOp
@Disabled

public class Ps4Ex3 extends OpMode {

    double mass_of_robot = 5;

    // Data of motor 1
    double motor1_power = 0.8;
    double motor1_friction = 2.3;
    double motor1_speed = 0.0;

    // Data of motor 2
    double motor2_power = 0.83;
    double motor2_friction = 3.2;
    double motor2_speed = 0.0;

    // Data of motor 3
    double motor3_power = 0.74;
    double motor3_friction = 2.7;
    double motor3_speed = 0.0;

    // Data of motor 4
    double motor4_power = 0.79;
    double motor4_friction = 2.9;
    double motor4_speed = 0.0;

    double robot_speed = 0.0;
    @Override
    public void init()
    {
        motor1_speed = motor1_power * motor1_friction / mass_of_robot;

        motor2_speed = motor2_power * motor2_friction / mass_of_robot;

        motor3_speed = motor3_power * motor3_friction / mass_of_robot;

        motor4_speed = motor4_power * motor4_friction / mass_of_robot;

        robot_speed = (motor1_speed + motor2_speed + motor3_speed + motor4_speed) / 4;

        telemetry.addData("Speed of the robot: ","%.2f",robot_speed);
    }
    @Override
    public void loop()
    {

    }

}


