package org.firstinspires.ftc.teamcode.Utils.RoadRunner.drive.opmode.Base;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Base {

    private HardwareMap hardwareMap;

    private DcMotorEx BLMotor;
    private DcMotorEx BRMotor;
    private DcMotorEx FLMotor;
    private DcMotorEx FRMotor;

    public Base(HardwareMap hardwareMap,DcMotorEx BLMotor, DcMotorEx BRMotor, DcMotorEx FLMotor, DcMotorEx FRMotor) {
        this.hardwareMap = hardwareMap;
        this.BLMotor = BLMotor;
        this.BRMotor = BRMotor;
        this.FLMotor = FLMotor;
        this.FRMotor = FRMotor;

    }

    public Base(HardwareMap hardwareMap){

        initialize(hardwareMap);

    }

    public HardwareMap getHardwareMap(){
        return hardwareMap;
    }

    public DcMotorEx getBLMotor() {
        return BLMotor;
    }

    public DcMotorEx getBRMotor() {
        return BRMotor;
    }

    public DcMotorEx getFLMotor() {
        return FLMotor;
    }

    public DcMotorEx getFRMotor() {
        return FRMotor;
    }

    public void initialize(HardwareMap hardwareMap){

        BLMotor = hardwareMap.get(DcMotorEx.class, "BLMotor");
        BRMotor = hardwareMap.get(DcMotorEx.class, "BRMotor");
        FLMotor = hardwareMap.get(DcMotorEx.class, "FLMotor");
        FRMotor = hardwareMap.get(DcMotorEx.class, "FRMotor");

        BLMotor.setDirection(DcMotorEx.Direction.FORWARD);
        BRMotor.setDirection(DcMotorEx.Direction.REVERSE);
        FLMotor.setDirection(DcMotorEx.Direction.REVERSE);
        FRMotor.setDirection(DcMotorEx.Direction.FORWARD);

        BLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMotorsMode(DcMotor.RunMode runMode){
        BLMotor.setMode(runMode);
        BRMotor.setMode(runMode);
        FLMotor.setMode(runMode);
        FRMotor.setMode(runMode);
    }

    public void setMotorsPower(double power){
        BLMotor.setPower(power);
        BRMotor.setPower(power);
        FLMotor.setPower(power);
        FRMotor.setPower(power);
    }
}
