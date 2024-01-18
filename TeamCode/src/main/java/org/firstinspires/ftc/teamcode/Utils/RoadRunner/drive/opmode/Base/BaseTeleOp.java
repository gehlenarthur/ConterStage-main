package org.firstinspires.ftc.teamcode.Utils.RoadRunner.drive.opmode.Base;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import java.util.ArrayList;
import java.util.List;

public class BaseTeleOp extends Base{

    public BaseTeleOp(HardwareMap hardwareMap, DcMotorEx BLMotor, DcMotorEx BRMotor, DcMotorEx FLMotor, DcMotorEx FRMotor) {
        super(hardwareMap, BLMotor, BRMotor, FLMotor, FRMotor);
    }

    public BaseTeleOp(HardwareMap hardwareMap) {
        super(hardwareMap);
    }

    public void BaseControl(double drive, double strafe,double twist){



        // Cria uma lista dos motores e calcula qual deve ser a velocidade de giro do motor(power)
        List<Double> doubleList = new ArrayList<>();
        doubleList.add((drive - strafe + twist)); //0
        doubleList.add((drive + strafe - twist)); //1
        doubleList.add((drive + strafe + twist)); //2
        doubleList.add((drive - strafe - twist)); //3
        // leftFront      doubleList.add((drive - + 1 + twist)); //0 -1
        //  rightFront    doubleList.add((drive + +1 - twist)); //1 -1
        // leftBack       doubleList.add((drive + +1 + twist)); //2 +1
        // rightBack      doubleList.add((drive - +1 - twist)); //3 +1
        Double max = Math.abs(doubleList.get(0));
        for (int i = 1; i < doubleList.size(); i++) {
            if (max < Math.abs(doubleList.get(i))) {
                max = Math.abs(doubleList.get(i));
            }
        }
        if (max > 1) {
            for (int i = 0; i < doubleList.size(); i++) {
                doubleList.set(i, doubleList.get(i) / max);
            }
        }
        // Pega os valores de power calculados da lista e faz com que os motores girem com o devido power
        getFLMotor().setPower(doubleList.get(0));
        getFRMotor().setPower(doubleList.get(1));
        getBRMotor().setPower(doubleList.get(2));
        getBLMotor().setPower(doubleList.get(3));

    }

    public void BaseControlVelocity(double drive, double strafe,double twist, double degreesPerSeconds){

        // Cria uma lista dos motores e calcula qual deve ser a velocidade de giro do motor(power)
        List<Double> doubleList = new ArrayList<>();
        doubleList.add((drive - strafe + twist)); //0
        doubleList.add((drive + strafe - twist)); //1
        doubleList.add((drive + strafe + twist)); //2
        doubleList.add((drive - strafe - twist)); //3
        // leftFront      doubleList.add((drive - + 1 + twist)); //0 -1
        //  rightFront    doubleList.add((drive + +1 - twist)); //1 -1
        // leftBack       doubleList.add((drive + +1 + twist)); //2 +1
        // rightBack      doubleList.add((drive - +1 - twist)); //3 +1
        Double max = Math.abs(doubleList.get(0));
        for (int i = 1; i < doubleList.size(); i++) {
            if (max < Math.abs(doubleList.get(i))) {
                max = Math.abs(doubleList.get(i));
            }
        }
        if (max > 1) {
            for (int i = 0; i < doubleList.size(); i++) {
                doubleList.set(i, doubleList.get(i) / max);
            }
        }
        // Pega os valores de power calculados da lista e faz com que os motores girem com o devido power
        getFLMotor().setVelocity(doubleList.get(0) * degreesPerSeconds, AngleUnit.DEGREES);
        getFRMotor().setVelocity(doubleList.get(1) * degreesPerSeconds, AngleUnit.DEGREES);
        getBRMotor().setVelocity(doubleList.get(2) * degreesPerSeconds, AngleUnit.DEGREES);
        getBLMotor().setVelocity(doubleList.get(3) * degreesPerSeconds, AngleUnit.DEGREES);

    }
}
