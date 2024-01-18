package org.firstinspires.ftc.teamcode.Utils.Enconder;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Encoder {

    public void encoderDeegres( DcMotorEx motor,double deegres, double power,double counts,double time) {

        double target = deegres * counts;
        motor.setTargetPosition((int) target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor.setPower(power);

        ElapsedTime runTime = new ElapsedTime();
        while (runTime.seconds() < time && motor.isBusy()) {

            Thread.yield();
        }

        runTime = null;
    }

    public void encoderDeegres( DcMotorEx motor, double deegres, double power, double counts) {

        double target = deegres * counts;
        motor.setTargetPosition((int) target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor.setPower(power);

    }

    public void encoderDeegresVelocity( DcMotorEx motor,double deegres, double degreesPerSeconds,double counts,double time) {

        double target = deegres * counts;
        motor.setTargetPosition((int) target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor.setVelocity(degreesPerSeconds, AngleUnit.DEGREES);

        ElapsedTime runTime = new ElapsedTime();
        while (runTime.seconds() < time && motor.isBusy()) {

            Thread.yield();
        }


        runTime = null;
    }

    public void encoderDeegresVelocity( DcMotorEx motor,double deegres, double degreesPerSeconds,double counts) {

        double target = deegres * counts;
        motor.setTargetPosition((int) target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor.setVelocity(degreesPerSeconds, AngleUnit.DEGREES);


    }
}
