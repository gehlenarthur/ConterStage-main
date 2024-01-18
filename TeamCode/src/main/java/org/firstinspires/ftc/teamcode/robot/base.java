package org.firstinspires.ftc.teamcode.robot;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Utils.RoadRunner.drive.SampleMecanumDrive;

@TeleOp(group = "drive")
public class base extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (!isStopRequested()) {
            drive.setWeightedDrivePower(
                    new Pose2d(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x));

            drive.update();







            Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());

            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.addData("porta", drive.leftFront.getPortNumber());
            telemetry.addData("porta", drive.rightFront.getPortNumber());
            telemetry.addData("porta", drive.leftRear.getPortNumber());
            telemetry.addData("porta", drive.rightRear.getPortNumber());

            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.addData("power", drive.leftFront.getPower());
            telemetry.addData("power", drive.rightFront.getPower());
            telemetry.addData("power", drive.leftRear.getPower());
            telemetry.addData("power", drive.rightRear.getPower());

            telemetry.addData("left front modo", drive.leftFront.getDirection());
            telemetry.addData("right front modo", drive.rightFront.getDirection());
            telemetry.addData("left tras modo", drive.leftRear.getDirection());
            telemetry.addData("right tras modo", drive.rightRear.getDirection());

            telemetry.update();

        }
    }
}
