package org.firstinspires.ftc.teamcode.robot.t;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@TeleOp
public class roda extends LinearOpMode {
    DcMotorEx motor;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotorEx.class, "motor");
        waitForStart();

        while (opModeIsActive()) {
            motor.setPower(gamepad1.left_stick_x);
        }
    }
}
