package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled

@TeleOp

public class Motor {

    double velocity;

    double torque(double velocity, double mass)
    {
        double energy = mass + velocity;

        double acceleration = energy / mass;

        double torque = acceleration * 10;

        return torque;
    }
}
