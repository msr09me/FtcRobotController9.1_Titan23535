package org.firstinspires.ftc.teamcode.ProgrammingSessions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp

public class Ps5Ex2 extends OpMode {

    double motor1_velocity = 2.1;
    double motor1_power = 0.9;

    double motor2_velocity = 1.5;
    double motor2_power = 0.6;

    double motor3_velocity = 1.78;
    double motor3_power = 0.8;

    double motor4_velocity = 1.89;
    double motor4_power = 0.76;

    double resistance = 10;

    double motor_voltage(double velocity, double power, double resistance)
    {
        double current;
        double voltage;

        current = power / velocity;

        voltage = current * resistance;

        return voltage;
    }
    @Override
    public void init()
    {
        double motor1_voltage;
        double motor2_voltage;
        double motor3_voltage;
        double motor4_voltage;

        motor1_voltage = motor_voltage(motor1_velocity, motor1_power, resistance);
        motor2_voltage = motor_voltage(motor2_velocity, motor2_power, resistance);
        motor3_voltage = motor_voltage(motor3_velocity, motor3_power, resistance);
        motor4_voltage = motor_voltage(motor4_velocity, motor4_power, resistance);

    }
    @Override
    public void loop()
    {

    }

}


