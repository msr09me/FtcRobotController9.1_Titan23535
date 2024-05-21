package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp

public class Ps5Ex1 extends OpMode {

    double motor1Velocity = 2.0;
    double motor2Velocity = 4.0;
    double motor3Velocity = 7.0;
    double motor4_velocity = 8.0;

    double mass = 10.0;

    double motor1_torque;
    double motor2_torque;
    double motor3_torque;
    double motor4_torque;

    double motor_torque(double mass, double velocity)
    {
        double energy = 0.0;
        double acceleration;
        double torque;

        energy = mass + velocity;

        acceleration = energy / mass;

        torque = acceleration * 10;

        return torque;
    }
    @Override
    public void init()
    {
        motor1_torque = motor_torque(mass, motor1Velocity);
        motor2_torque = motor_torque(mass, motor2Velocity);
        motor3_torque = motor_torque(mass, motor3Velocity);
        motor4_torque = motor_torque(mass, motor4_velocity);

        telemetry.addData("Motor 1 Torque: ","%.2f", motor1_torque);
        telemetry.addData("Motor 2 Torque: ","%.2f", motor2_torque);
        telemetry.addData("Motor 3 Torque: ","%.2f", motor3_torque);
        telemetry.addData("Motor 4 Torque: ","%.2f", motor4_torque);

    }
    @Override
    public void loop()
    {

    }

}


