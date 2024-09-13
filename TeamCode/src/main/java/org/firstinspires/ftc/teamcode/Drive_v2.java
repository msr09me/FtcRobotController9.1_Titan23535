package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.mechanisms.Drive_Mechanism_v2;

@TeleOp(name = "Demo Drive", group = "test")


public class Drive_v2 extends OpMode
{
    Drive_Mechanism_v2 driveFourDcMotor = new Drive_Mechanism_v2();

    private ElapsedTime runtime = new ElapsedTime();

    String mode = "Very Slow";

    double speed_percentage = 25.0;

    @Override
    public void init() {

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        runtime.reset();

        driveFourDcMotor.init(hardwareMap);

    }

    // run until the end of the match (driver presses STOP)
    @Override
    public void loop() {

        if (runtime.seconds() >= 90)
        {
            requestOpModeStop();
        }

        //------------------------------------------------------------------------------------------

        //Driving using 4 Mecanum Wheels

        // Set the Mode

        if (gamepad1.a){
            mode = "Normal";
            speed_percentage = 25.0;
        } else if (gamepad1.b) {
            mode = "Slow";
            speed_percentage = 25.0;
        } else if (gamepad1.y) {
            mode = "Very Slow";
            speed_percentage = 25.0;
        } else if (gamepad1.x) {
            mode = "Turtle Mode";
            speed_percentage = 25.0;
        }

        // Uses left joystick to go forward, backward, left, and right, and right joystick to rotate.

        double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  -gamepad1.right_stick_x;

        driveFourDcMotor.setDriveMotorPower(axial, lateral, yaw, speed_percentage );

        //------------------------------------------------------------------------------------

        // Print Information
        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Mode",mode);
        telemetry.update();
    }

}
