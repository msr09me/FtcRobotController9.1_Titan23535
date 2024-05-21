package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled

public class Ps3Ex3 extends OpMode {
    double massRobot = 10;
    double velocity = 10;
    @Override
    public void init()
    {

    }
    @Override
    public void loop()
    {
        telemetry.addData("Mass",massRobot);
        telemetry.addData("Velocity",velocity);
    }
}