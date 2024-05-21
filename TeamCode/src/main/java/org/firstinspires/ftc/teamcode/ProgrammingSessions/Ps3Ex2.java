package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled

public class Ps3Ex2 extends OpMode {
    @Override
    public void init()
    {
        telemetry.addData("","");
        telemetry.addData("Team Name","Titan");
        telemetry.addData("Torque","5");
    }
    @Override
    public void loop()
    {
        telemetry.addData("Team Number","23535");
    }
}