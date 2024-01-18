package org.firstinspires.ftc.teamcode.robot.t;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
@TeleOp
public class testeservo extends LinearOpMode {

    CRServo servo1;

    @Override
    public void runOpMode() throws InterruptedException {

        servo1 = hardwareMap.get(CRServo.class, "Servo1");
        waitForStart();

        while (opModeIsActive()){

            if(gamepad1.right_bumper){
                servo1.setPower(0.9);

            }else
            if(gamepad1.left_bumper){
                servo1.setPower(-0.9);

            }
        }

    }
}
