/*package org.firstinspires.ftc.teamcode.Utils.IMU;

/*import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;*/

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
/*import org.firstinspires.ftc.teamcode.Robot.Base.Base;
import org.firstinspires.ftc.teamcode.Robot.Base.BaseAutonomo;
import org.firstinspires.ftc.teamcode.Robot.Base.BaseTeleOp;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "IMUrotate")
public class IMUrotate {

    BNO055IMU imu;
    private float lastHeadingAngleImu;
    private double globalAngleImu;
    BaseAutonomo base;

    public IMUrotate(BaseAutonomo base, HardwareMap hardwareMap) {
        this.base = base;

        setupImu(hardwareMap);
    }

    private void setupImu(HardwareMap hardwareMap) {

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public void rotateUsingImu(int degrees) {


        if (degrees < 0) {
            while ((getAngle() > degrees) || (getAngle() == 0)) {
                setWheelsPowerFromDegrees(degrees);
            }
        } else {
            while (getAngle() < degrees) {
                setWheelsPowerFromDegrees(degrees);
            }
        }

        base.setWheelsPower(0.00, 0.00, 0.00);



    }

    public void resetAngle() {

        lastHeadingAngleImu = imu
                .getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
        globalAngleImu = 0;
    }

    private double getAngle() {

        float headingAngleImu = imu
                .getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
        double deltaAngle = headingAngleImu - lastHeadingAngleImu;

        if (deltaAngle < -180) {
            deltaAngle += 360;
        } else if (deltaAngle > 180) {
            deltaAngle -= 360;
        }

        globalAngleImu += deltaAngle;
        lastHeadingAngleImu = headingAngleImu;

        return globalAngleImu;
    }

    public double checkDirection() {

        double correction, angle, gain = .10;

        angle = getAngle();

        if (angle == 0) {
            correction = 0;
        } else {
            correction = -angle;
        }

        correction = correction * gain;

        return correction;
    }

    private void setWheelsPowerFromDegrees(int degrees) {

        double power = 1 - (Math.abs(getAngle()) / Math.abs(degrees));

        base.setWheelsPower(0.00, 0.00, degrees > 0 ? 0.75 : -0.75 * 0);

    }


}*/
