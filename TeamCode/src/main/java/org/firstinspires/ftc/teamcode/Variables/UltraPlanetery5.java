package org.firstinspires.ftc.teamcode.Variables;

public class UltraPlanetery5 {

    public static final double COUNTS_PER_MOTOR =  140;
    public static final double DRIVE_GEAR_REDUCTION = 1.0;

    public static final double WHEEL_DIAMETER_INCHES = 3.0;
    public static final double COUNTS_PER_INCH =
            (COUNTS_PER_MOTOR * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);

    public static final double WHEEL_DIAMETER_CM = 7.62;
    public static final double COUNTS_PER_CM =
            (COUNTS_PER_MOTOR * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_CM * 3.1415);

    public static final double COUNTS_PER_DEGREES =
            (COUNTS_PER_MOTOR / 360);
}
