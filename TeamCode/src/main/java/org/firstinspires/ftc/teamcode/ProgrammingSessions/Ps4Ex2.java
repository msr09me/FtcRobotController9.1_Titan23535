package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled

public class Ps4Ex2 extends OpMode {

    double mass = 10.0;

    // Info for Motor 1

    double motor1_velocity = 2.0;
    double motor1_energy = 0.0;
    double motor1_acceleration = 0.0;
    double motor1_torque = 0.0;

    // Info for Motor 2

    double motor2_velocity = 4.0;
    double motor2_energy = 0.0;
    double motor2_acceleration = 0.0;
    double motor2_torque = 0.0;

    // Info for Motor 3

    double motor3_velocity = 7.0;
    double motor3_energy = 0.0;
    double motor3_acceleration = 0.0;
    double motor3_torque = 0.0;

    // Info for Motor 4

    double motor4_velocity = 8.0;
    double motor4_energy = 0.0;
    double motor4_acceleration = 0.0;
    double motor4_torque = 0.0;

    @Override
    public void init()
    {
        // Equations for Motor 1

        motor1_energy =  mass + motor1_velocity;

        motor1_acceleration = motor1_energy / mass;

        motor1_torque = motor1_acceleration * 10;

        telemetry.addData("Torque of motor 1: ","%.2f",motor1_torque);

       // Equations for Motor 2
       
        motor2_energy = mass + motor2_velocity;

        motor2_acceleration = motor2_energy / mass;

        motor2_torque = motor2_acceleration * 10;

        telemetry.addData("Torque of motor 2: ","%.2f",motor2_torque);

        // Equations for Motor 3

        motor3_energy =  mass + motor3_velocity;

        motor3_acceleration = motor3_energy / mass;

        motor3_torque = motor3_acceleration * 10;

        telemetry.addData("Torque of motor 3: ","%.2f",motor3_torque);

        // Equations for Motor 4

        motor4_energy =  mass + motor4_velocity;

        motor4_acceleration = motor4_energy / mass;

        motor4_torque = motor4_acceleration * 10;

        telemetry.addData("Torque of motor 4: ","%.2f",motor4_torque);
    }
    @Override
    public void loop()
    {

    }
}