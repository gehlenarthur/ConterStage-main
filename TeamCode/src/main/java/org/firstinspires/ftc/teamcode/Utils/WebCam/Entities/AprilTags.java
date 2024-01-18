/*
 * Copyright (c) 2021 OpenFTC Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.firstinspires.ftc.teamcode.Utils.WebCam.Entities;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.List;

@Autonomous
public class AprilTags
{
    private OpenCvCamera camera;
    private AprilTagDetectionPipeline aprilTagDetectionPipeline;

    private static final double METER = 1;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    private double fx = 578.272;
    private double fy = 578.272;
    private double cx = 402.145;
    private double cy = 221.506;

    // UNITS ARE METERS
    private double tagsize = 0.166;

    private int tag0 = 6; // Tag ID 18 from the 36h11 family
    private int tag1 = 9;
    private int tag2 = 12;

    private AprilTagDetection tagOfInterest = null;

    public OpenCvCamera getCamera() {
        return camera;
    }

    public AprilTagDetectionPipeline getAprilTagDetectionPipeline() {
        return aprilTagDetectionPipeline;
    }

    public List<AprilTagDetection> getLatestDetections(){

        return  aprilTagDetectionPipeline.getLatestDetections();
    }

    public double getFx() {
        return fx;
    }

    public double getFy() {
        return fy;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getTagsize() {
        return tagsize;
    }

    public int getTag0() {
        return tag0;
    }

    public int getTag1() {
        return tag1;
    }

    public int getTag2() {
        return tag2;
    }

    public AprilTagDetection getTagOfInterest() {
        return tagOfInterest;
    }

    public void setTagOfInterest(AprilTagDetection tagOfInterest) {
         this.tagOfInterest = tagOfInterest;
    }

    public void initCamera(HardwareMap hardwareMap  ){

       int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
       camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
       aprilTagDetectionPipeline = new AprilTagDetectionPipeline( tagsize,  fx,  fy,  cx,  cy);

       camera.setPipeline( aprilTagDetectionPipeline);
       camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
       {
           @Override
           public void onOpened()
           {
               camera.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
           }

           @Override
           public void onError(int errorCode)
           {

           }
       });
   }

    public void tagToTelemetry(AprilTagDetection detection, Telemetry telemetry)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*METER));
       // telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
       // telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
       // telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
    }
}