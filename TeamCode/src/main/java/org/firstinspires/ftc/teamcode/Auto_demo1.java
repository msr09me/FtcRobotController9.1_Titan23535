
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto Demo blue Near", group="Robot")

public class Auto_demo1 extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;

    private ElapsedTime     runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 28;    //
    static final double     DRIVE_GEAR_REDUCTION    =  4.0;     // 4:1 External Gearing.
    static final double     WHEEL_DIAMETER_INCHES   =  2.95276;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.15;


    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");



        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);



        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Starting at",  "%7d :%7d",
                leftFrontDrive.getCurrentPosition(),
                leftBackDrive.getCurrentPosition(),
                rightFrontDrive.getCurrentPosition(),
                rightBackDrive.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        /*
            The drive modes are: forward, backward, left, right, turnLeft, turnRight

         */


        drive("forward", 8, DRIVE_SPEED, 5.0);
        drive("left", 50, DRIVE_SPEED, 5.0);

        drive("backward",4,DRIVE_SPEED,10.0);





        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);  // pause to display final telemetry message.
    }

    public void drive(String driveMode, double distance, double speed, double timeoutS)
    {

        int newLeftFrontTarget=0;
        int newLeftBackTarget=0;
        int newRightFrontTarget=0;
        int newRightBackTarget=0;

        // Ensure that the OpMode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller

            if (driveMode == "forward"){
                newLeftFrontTarget = leftFrontDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
                newLeftBackTarget = leftBackDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
                newRightFrontTarget = rightFrontDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
                newRightBackTarget = rightBackDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
            } else if (driveMode == "backward") {
                newLeftFrontTarget = leftFrontDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
                newLeftBackTarget = leftBackDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
                newRightFrontTarget = rightFrontDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
                newRightBackTarget = rightBackDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
            } else if (driveMode == "right") {
                newLeftFrontTarget = leftFrontDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
                newLeftBackTarget = leftBackDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
                newRightFrontTarget = rightFrontDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
                newRightBackTarget = rightBackDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

            } else if (driveMode == "left") {
                newLeftFrontTarget = leftFrontDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);
                newLeftBackTarget = leftBackDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
                newRightFrontTarget = rightFrontDrive.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
                newRightBackTarget = rightBackDrive.getCurrentPosition() + (int)(-distance * COUNTS_PER_INCH);

            }else if (driveMode == "turnLeft") {
                leftFrontDrive.setPower(Math.abs(-speed));
                leftBackDrive.setPower(Math.abs(-speed));
                rightFrontDrive.setPower(Math.abs(speed));
                rightBackDrive.setPower(Math.abs(speed));

            } else if (driveMode == "turnRight") {
                leftFrontDrive.setPower(Math.abs(speed));
                leftBackDrive.setPower(Math.abs(speed));
                rightFrontDrive.setPower(Math.abs(-speed));
                rightBackDrive.setPower(Math.abs(-speed));

            }

            leftFrontDrive.setTargetPosition(newLeftFrontTarget);
            leftBackDrive.setTargetPosition(newLeftBackTarget);
            rightFrontDrive.setTargetPosition(newRightFrontTarget);
            rightBackDrive.setTargetPosition(newRightBackTarget);


            // Turn On RUN_TO_POSITION

            leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();

            leftFrontDrive.setPower(Math.abs(speed));
            leftBackDrive.setPower(Math.abs(speed));
            rightFrontDrive.setPower(Math.abs(speed));
            rightBackDrive.setPower(Math.abs(speed));




            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (leftFrontDrive.isBusy() && leftBackDrive.isBusy()
                            && rightFrontDrive.isBusy() && rightBackDrive.isBusy())) {


                // Display it for the driver.
                telemetry.addData("Running to",  " %4d :%4d :%4d :%4d", newLeftFrontTarget, newLeftBackTarget,  newRightFrontTarget, newRightBackTarget);
                telemetry.addData("Currently at",  " at %4d :%4d :%4d :%4d",
                        leftFrontDrive.getCurrentPosition(), leftBackDrive.getCurrentPosition(), rightFrontDrive.getCurrentPosition(), rightBackDrive.getCurrentPosition());
                // telemetry.addData("Speed","%4d :%4d :%4d :%4d", leftFrontDrive.getPower(), leftBackDrive.getPower(), rightFrontDrive.getPower(), rightBackDrive.getPower());
                telemetry.update();
            }

            // Stop all motion;
            leftFrontDrive.setPower(0);
            leftBackDrive.setPower(0);
            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);

            // Turn off RUN_TO_POSITION
            leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(250);   // optional pause after each move.
        }
    }
}
