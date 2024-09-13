package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Climb_Mechanism_v2 {

    // Create 2 objects from DCMotor class for our 2 DC motors to climb

    private DcMotor climberLeftMotor = null;
    private DcMotor climberRightMotor = null;

    public void init(HardwareMap hwMap)
    {
        // Scan the robot for the DC motors

        climberLeftMotor = hwMap.get(DcMotor.class, "climber_left_motor");
        climberRightMotor = hwMap.get(DcMotor.class, "climber_right_motor");

        // Set the direction of the rotation of the motors

        climberLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        climberRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Enable brake

        climberLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climberRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    public void setClimberMotorPower(double power)
    {
        // Set the power to each DC motor

        if (power > 1.0 || power < -1.0) {
            power = 1.0;
        }

        // 100% power
        power = power * 1;

        // Set the power to the motors

        climberLeftMotor.setPower(power);
        climberRightMotor.setPower(power);
    }

    public void droneDrive(double power, int target)
    {
        // clm = climber left motor
        // crm = climber right motor

        int clm_position = climberLeftMotor.getCurrentPosition() + target;
        int crm_position = climberRightMotor.getCurrentPosition() + target;

        climberLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        climberRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        climberLeftMotor.setPower(Math.abs(power));
        climberRightMotor.setPower(Math.abs(power));

        climberLeftMotor.setTargetPosition(target);
        climberRightMotor.setTargetPosition(target);

        climberLeftMotor.setPower(Math.abs(0));
        climberRightMotor.setPower(Math.abs(0));

        climberLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        climberRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public String  toString()
    {
        return ": " + climberLeftMotor.getZeroPowerBehavior();
        // return ": " + climberLeftMotor.getPower() + " " + climberRightMotor.getPower();
    }
}
