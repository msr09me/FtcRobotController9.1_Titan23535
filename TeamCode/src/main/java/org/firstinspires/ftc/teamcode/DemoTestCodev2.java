package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name = "Demo2", group = "test")


public class DemoTestCodev2 extends OpMode
{

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        runtime.reset();
    }

    // run until the end of the match (driver presses STOP)
    @Override
    public void loop() {

        if (runtime.seconds() >= 5)
        {
            requestOpModeStop();
        }


        // Print Information
        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }

}
