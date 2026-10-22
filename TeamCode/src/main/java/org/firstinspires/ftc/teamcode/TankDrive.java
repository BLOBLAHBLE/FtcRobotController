package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class TankDrive extends OpMode {
    public DcMotor leftFrontF = null;
    public DcMotor rightFrontF = null;
    public DcMotor leftBackF = null;
    public DcMotor rightBackF = null;
    public DcMotor rightBackB = null;
    public DcMotor rightFrontB = null;
    public DcMotor leftBackB = null;
    public DcMotor leftFrontB = null;
    @Override
    public void init() {
        leftFrontF = hardwareMap.get(DcMotor.class, "left_front_forward");
        leftBackF = hardwareMap.get(DcMotor.class, "left_back_forward");
        rightFrontF = hardwareMap.get(DcMotor.class, "right_front_forward");
        rightBackF = hardwareMap.get(DcMotor.class, "right_back_forward");

        leftFrontB = hardwareMap.get(DcMotor.class, "left_front_backward");
        leftBackB = hardwareMap.get(DcMotor.class, "left_back_backward");
        rightFrontB = hardwareMap.get(DcMotor.class, "right_front_backward");
        rightBackB = hardwareMap.get(DcMotor.class, "right_back_backward");

        leftFrontF.setDirection(DcMotor.Direction.FORWARD);
        leftBackF.setDirection(DcMotor.Direction.FORWARD);
        rightFrontF.setDirection(DcMotor.Direction.FORWARD);
        rightBackF.setDirection(DcMotor.Direction.FORWARD);

        leftFrontB.setDirection(DcMotor.Direction.REVERSE);
        leftBackB.setDirection(DcMotor.Direction.REVERSE);
        rightFrontB.setDirection(DcMotor.Direction.REVERSE);
        rightBackB.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData(">", "Robot Ready.  Press START.");
    }

    @Override
    public void init_loop() {
        super.init_loop();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        double rightForward;
        double leftForward;
        double leftBackward;
        double rightBackward;

        rightForward = -gamepad1.right_stick_y;
        leftForward = -gamepad1.left_stick_y;

        leftBackF.setPower(leftForward);
        leftFrontF.setPower(leftForward);
        rightBackF.setPower(rightForward);
        rightFrontF.setPower(rightForward);

        rightBackward = gamepad1.right_stick_y;
        leftBackward = gamepad1.left_stick_y;

        leftBackB.setPower(leftBackward);
        leftFrontB.setPower(leftBackward);
        rightBackB.setPower(rightBackward);
        rightFrontF.setPower(rightBackward);

    }

    @Override
    public void stop() {
        super.stop();
    }
}
