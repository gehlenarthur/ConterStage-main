package org.firstinspires.ftc.teamcode.robot.t;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class nome extends LinearOpMode {

    double countsPorVolta = 288;
    double countsPorVoltaUltra = 1680;
    double counstPorGrau = countsPorVolta / 360;

    DcMotorEx DFmotor;
    DcMotorEx DTmotor;
    DcMotorEx EFmotor;
    DcMotorEx ETmotor;

    DcMotorEx motor;


    @Override
    public void runOpMode() throws InterruptedException {
        //0 - 1
        initialize();
        waitForStart();

       while (opModeIsActive()) {

           DFmotor.setPower(-gamepad1.left_stick_y);
           DTmotor.setPower(-gamepad1.left_stick_y);
           EFmotor.setPower(-gamepad1.left_stick_y);
           ETmotor.setPower(-gamepad1.left_stick_y);

           DFmotor.setPower(-gamepad1.right_stick_x);
           DTmotor.setPower(-gamepad1.right_stick_x);
           EFmotor.setPower(gamepad1.right_stick_x);
           ETmotor.setPower(gamepad1.right_stick_x);

           DFmotor.setPower(gamepad1.left_stick_x);
           DTmotor.setPower(-gamepad1.left_stick_x);
           EFmotor.setPower(-gamepad1.left_stick_x);
           ETmotor.setPower(gamepad1.left_stick_x);

        /*   if(gamepad1.a == true){

               motor.setPower(1);
           }

           if(gamepad1.b == true){

               motor.setPower(-1);
           }*/

           if(gamepad1.a){

               encoder(90);
           }

           if(gamepad1.b){
               encoder(30);
           }

           if (gamepad1.x){
               encoder(0);
           }
       }
    }
    private void initialize(){

        DFmotor = hardwareMap.get(DcMotorEx.class, "DFmotor");
        DTmotor = hardwareMap.get(DcMotorEx.class, "DTmotor");
        EFmotor = hardwareMap.get(DcMotorEx.class, "EFmotor");
        ETmotor = hardwareMap.get(DcMotorEx.class,"ETmotor");

        motor = hardwareMap.get(DcMotorEx.class,"motor");

        DFmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        DTmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        EFmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        ETmotor.setDirection(DcMotorSimple.Direction.FORWARD);

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void encoder(double graus){

        double position = graus * counstPorGrau;
        motor.setTargetPosition((int) position);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(0.5);



    }
}
