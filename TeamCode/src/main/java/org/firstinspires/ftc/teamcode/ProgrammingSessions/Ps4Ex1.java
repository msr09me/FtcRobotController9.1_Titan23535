package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled

public class Ps4Ex1 extends OpMode {

    double mass = 10.0;
    double velocity = 5.0;

    double energy = 0.0;
    double acceleration = 0.0;
    double torque = 0.0;

    @Override
    public void init()
    {
        energy =  mass + velocity;

        acceleration = energy / mass;

        torque = acceleration * 10;

        telemetry.addData("Torque of the motor: ","%.2f",torque);
    }
    @Override
    public void loop()
    {}
}