package org.firstinspires.ftc.teamcode.robot.t;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Variables.UltraPlanetery345;

public class teste3 extends LinearOpMode {

    DcMotorEx motor1;
    int target = 0;

    @Override
    public void runOpMode() throws InterruptedException {

    motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
    waitForStart();

    while (opModeIsActive()){
        if(gamepad1.a){
            target = (int)(UltraPlanetery345.COUNTS_PER_MOTOR * 40); // 40 representa a orientação em graus do motor
            motor1.setTargetPosition(target);
            motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor1.setPower(0.5);

            }
        }
    }
}
