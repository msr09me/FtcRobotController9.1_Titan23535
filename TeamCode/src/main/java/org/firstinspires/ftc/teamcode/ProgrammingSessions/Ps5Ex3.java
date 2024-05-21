package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp

public class Ps5Ex3 extends OpMode {

    double arm_power(double distance, double time, double efficiency)
    {
        double velocity;
        double power;

        velocity = distance / time;

        power = velocity * efficiency;

        return power;
    }

    double left_arm_distance = 16;

    double left_arm_time = 5;

    double left_arm_efficiency = 0.4;
    @Override
    public void init()
    {

    }
    @Override
    public void loop()
    {

    }

}


