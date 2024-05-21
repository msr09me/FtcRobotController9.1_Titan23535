package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Climb_Mechanism_v1 {

    // Create 2 objects from DCMotor class for our 2 DC motors to climb

    private DcMotor climberLeftMotor = null;
    private DcMotor climberRightMotor = null;

    public void init(HardwareMap hwMap) {

        // Scan the robot for the DC motors

        climberLeftMotor = hwMap.get(DcMotor.class, "climber_left_motor");
        climberRightMotor = hwMap.get(DcMotor.class, "climber_right_motor");

        // Set the direction of the rotation of the motors

        climberLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        climberRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        
    }

    public void setClimberMotorPower(double power) {

        // Set the power to each DC motor

        if (power > 1.0) {
            power = 1.0;
        }

        if (power < -1.0) {
            power = -1.0;
        }


        double climber_left_motor = power;
        double climber_right_motor = power;

        // Set the power to the motors

        climberLeftMotor.setPower(climber_left_motor);
        climberRightMotor.setPower(climber_right_motor);
    }
}
