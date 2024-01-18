package org.firstinspires.ftc.teamcode.robot.t;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Utils.RoadRunner.drive.SampleMecanumDrive;



@TeleOp(group = "drive")
public class baseBraco extends LinearOpMode {

    DcMotorEx motor1;
    DcMotorEx motor2;
    CRServo servo1;
    int i = 3;

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        servo1 = hardwareMap.get(CRServo.class, "Servo1");


        //motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motor1.setDirection(DcMotorEx.Direction.REVERSE);

        motor2.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();

        while (!isStopRequested()) {
            drive.setWeightedDrivePower(
                    new Pose2d(gamepad1.left_stick_y/2, gamepad1.left_stick_x/2, -gamepad1.right_stick_x/2));

            drive.update();

            motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            motor2.setPower(gamepad1.right_stick_y/3);


            if(gamepad1.right_bumper){
                servo1.setPower(0.9);

            }else
            if(gamepad1.left_bumper){
                servo1.setPower(-0.9);

            }else


            if(gamepad1.a){
                encoderDeegres(motor1, 30, 0.2, 1680);

            }

            /*if(gamepad1.b){
                encoderDeegres(motor2, 36, 0.2, 288);
            }*/

            if(gamepad1.y) {
                encoderDeegres(motor1, 90, 0.2, 1680);

            }

            if(gamepad1.x) {
                encoderDeegres(motor1, 0, 0.2, 1680);


            }





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

            telemetry.addData("posição", (double)motor1.getCurrentPosition()/1680);
            telemetry.addData("posição", (double)motor2.getCurrentPosition()/288);

            telemetry.update();

        }
    }

    public void encoderDeegres(DcMotorEx motor, double deegres, double power, double counts) {

        double target = deegres * (counts/360);
        motor.setTargetPosition((int) target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor.setPower(power);

        /*ElapsedTime runtime = new ElapsedTime();

        while (runtime.seconds() < time){

            Thread.yield();
        }

        motor.setPower(0);

        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
    }



}
