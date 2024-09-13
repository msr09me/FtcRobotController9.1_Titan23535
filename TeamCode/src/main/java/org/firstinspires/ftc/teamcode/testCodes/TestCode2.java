package org.firstinspires.ftc.teamcode.testCodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.Climb_Mechanism_v1;
import org.firstinspires.ftc.teamcode.mechanisms.Drive_Mechanism_v2;
import org.firstinspires.ftc.teamcode.mechanisms.Drone_Mechanism_v1;


@TeleOp(name = "Drive, Climb, Drone", group = "test")

// TestCode2 is the update of TestCode1. It adds the climb mechanism.


public class TestCode2 extends OpMode
{
    Drive_Mechanism_v2 driveFourDcMotor = new Drive_Mechanism_v2();
    Drone_Mechanism_v1 droneServo = new Drone_Mechanism_v1();
    Climb_Mechanism_v1 climbTwoDcMotor = new Climb_Mechanism_v1();

    private ElapsedTime runtime = new ElapsedTime();

    String mode = "Very Slow";

    double speed_percentage = 25;

    static double drone_servo_angle = 0.5;

    @Override
    public void init() {

        // Wait for the game to start (driver presses PLAY)

        runtime.reset();

        driveFourDcMotor.init(hardwareMap);
        droneServo.init(hardwareMap);
        climbTwoDcMotor.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();


    }

    // run until the end of the match (driver presses STOP)
    @Override
    public void loop() {

        //------------------------------------------------------------------------------------------

        //Driving using 4 Mecanum Wheels

        // Set the Mode

        if (gamepad1.a){
            mode = "Normal";
            speed_percentage = 100.0;
        } else if (gamepad1.b) {
            mode = "Slow";
            speed_percentage = 75.0;
        } else if (gamepad1.y) {
            mode = "Very Slow";
            speed_percentage = 50.0;
        } else if (gamepad1.x) {
            mode = "Turtle Mode";
            speed_percentage = 25.0;
        }

        // Uses left joystick to go forward, backward, left, and right, and right joystick to rotate.

        double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  -gamepad1.right_stick_x;

        driveFourDcMotor.setDriveMotorPower(axial, lateral, yaw, speed_percentage );

        //------------------------------------------------------------------------------------------

        // Drone Mechanism

        if (gamepad2.x && gamepad2.left_bumper)
        {
            droneServo.setPosition(drone_servo_angle);
        }

        //------------------------------------------------------------------------------------------

        // Climb Mechanism

        double climberPower = gamepad2.left_trigger - gamepad2.right_trigger;

        if (gamepad2.a)
        {
            climberPower = climberPower * 0.3;
        }

        climbTwoDcMotor.setClimberMotorPower(climberPower);

        //------------------------------------------------------------------------------------------

        // Print Information
        // Show the elapsed game time and wheel power.

        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.addData("Mode",mode);

        telemetry.addData("Drone Servo Angle: ",drone_servo_angle);

        telemetry.addData("Climber Left and Right Motor Zero Power Behavior", climbTwoDcMotor.toString());

        telemetry.update();
    }
}
