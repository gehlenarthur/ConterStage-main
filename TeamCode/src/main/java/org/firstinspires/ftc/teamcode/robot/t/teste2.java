package org.firstinspires.ftc.teamcode.robot.t;

import static org.firstinspires.ftc.teamcode.Variables.UltraPlanetery345.COUNTS_PER_MOTOR;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class teste2 extends LinearOpMode {
    DcMotorEx motor1;
    DcMotorEx motor2;

    @Override
    public void runOpMode() throws InterruptedException {

        initialize();
        waitForStart();

        while (opModeIsActive()){

            if(gamepad1.a){
                encoderDeegres(motor1, 30, 0.2, 1680);
            }

           if(gamepad1.b){
               encoderDeegres(motor1, 45, 0.2, 1680);


           }

            if(gamepad1.y) {
                encoderDeegres(motor1, 60, 0.2, 1680);

            }

            if(gamepad1.x) {
                encoderDeegres(motor1, motor1.getCurrentPosition() - motor1.getCurrentPosition(), 0.2, 1680);


            }

            motor2.setPower(gamepad1.right_stick_x/3);

            telemetry.addData("posicao", motor1.getCurrentPosition());
            telemetry.addData("posicao", motor2.getCurrentPosition());
        }


    }

    public void encoderDeegres( DcMotorEx motor, double deegres, double power, double counts) {

        double target = deegres * (counts/360);
        motor.setTargetPosition((int) target);
        motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor.setPower(power);


    }

    public void initialize(){

        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motor1.setDirection(DcMotorEx.Direction.REVERSE )

        ;

        motor1.setZeroPowerBehavior(motor1.getZeroPowerBehavior());
        motor2.setZeroPowerBehavior(motor2.getZeroPowerBehavior());
    }








}