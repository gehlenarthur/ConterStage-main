package org.firstinspires.ftc.teamcode.robot.t;

public class pid {

    public class PIDController {
        private double kp; // Constante proporcional
        private double ki; // Constante integral
        private double kd; // Constante derivativa
        private double targetPosition;
        private double integral;
        private double previousError;

        public PIDController(double kp, double ki, double kd) {
            this.kp = kp;
            this.ki = ki;
            this.kd = kd;
            this.targetPosition = 0.0;
            this.integral = 0.0;
            this.previousError = 0.0;
        }

        public double calculate(double currentPosition) {
            double error = targetPosition - currentPosition;

            double proportional = kp * error;

            integral += error;
            double integralTerm = ki * integral;

            double derivative = kd * (error - previousError);
            previousError = error;

            return proportional + integralTerm + derivative;
        }

        public void setTargetPosition(double targetPosition) {
            this.targetPosition = targetPosition;
            integral = 0.0;
            previousError = 0.0;
        }

    }
}
