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

package org.firstinspires.ftc.teamcode.Utils.WebCam.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Utils.WebCam.Entities.AprilTags;
import org.openftc.apriltag.AprilTagDetection;

import java.util.ArrayList;

@Autonomous
public class testeAprilTags extends LinearOpMode
{

    AprilTags atc = new AprilTags();

    @Override
    public void runOpMode() throws InterruptedException {

        atc.initCamera(hardwareMap);


        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */
        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = (ArrayList<AprilTagDetection>) atc.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id ==  atc.getTag0() || tag.id ==  atc.getTag1() || tag.id ==  atc.getTag2())
                    {
                        atc.setTagOfInterest(tag);
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    atc.tagToTelemetry( atc.getTagOfInterest(), telemetry);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if( atc.getTagOfInterest() == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        atc.tagToTelemetry( atc.getTagOfInterest(), telemetry);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if( atc.getTagOfInterest() == null)
                {
                    telemetry.addLine("(The tag has never been seen)");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    atc.tagToTelemetry( atc.getTagOfInterest(), telemetry);
                }

            }

            telemetry.update();
            sleep(20);
        }

        /*
         * The START command just came in: now work off the latest snapshot acquired
         * during the init loop.
         */

        /* Update the telemetry */
        if( atc.getTagOfInterest() != null)
        {
            telemetry.addLine("Tag snapshot:\n");
            atc.tagToTelemetry( atc.getTagOfInterest(),telemetry);
            telemetry.update();
        }
        else
        {
            telemetry.addLine("No tag snapshot available, it was never sighted during the init loop :(");
            telemetry.update();
        }

        /* Actually do something useful */
        if ( atc.getTagOfInterest().id ==  atc.getTag0()){
            telemetry.addLine("tag0 identificada");
        }else if ( atc.getTagOfInterest().id ==  atc.getTag1()){
            telemetry.addLine("tag1 identificada");
        }else if ( atc.getTagOfInterest().id ==  atc.getTag2()){
            telemetry.addLine("tag2 identificada");
        }
        /* You wouldn't have this in your autonomous, this is just to prevent the sample from ending */
        while (opModeIsActive()) {sleep(20);}

    }
}