package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TankDrive extends OpMode {

    private DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void init() {

        frontLeft = hardwareMap.get(DcMotor.class, "left_front");
        backLeft = hardwareMap.get(DcMotor.class, "left_back");
        frontRight = hardwareMap.get(DcMotor.class, "right_front");
        backRight = hardwareMap.get(DcMotor.class, "right_back");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData(">", "Robot Ready.  Press START.");
    }

    @Override
    public void loop() {

        double left = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;

        double strafe = 0;
        if (gamepad1.right_bumper) strafe += 1;
        if (gamepad1.left_bumper) strafe -= 1;

        double fl = left + strafe;
        double fr = right - strafe;
        double bl = left - strafe;
        double br = right + strafe;

        double max = Math.max(1.0,
                Math.max(Math.abs(fl),
                        Math.max(Math.abs(fr),
                                Math.max(Math.abs(bl), Math.abs(br)))));

        frontRight.setPower(fr / max);
        frontLeft.setPower(fl / max);
        backRight.setPower(br / max);
        backLeft.setPower(bl / max);
    }

}