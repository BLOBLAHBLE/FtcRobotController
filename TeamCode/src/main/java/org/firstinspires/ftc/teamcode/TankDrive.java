package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TankDrive extends OpMode {
    public DcMotor leftfront = null;
    public DcMotor rightfront = null;
    public DcMotor leftback = null;
    public DcMotor rightback = null;
    @Override
    public void init() {
        leftfront = hardwareMap.get(DcMotor.class, "leftfront");
        leftback = hardwareMap.get(DcMotor.class, "leftback");
        rightfront = hardwareMap.get(DcMotor.class, "rightfront");
        rightback = hardwareMap.get(DcMotor.class, "rightback");

        leftfront.setDirection(DcMotor.Direction.FORWARD);
        leftback.setDirection(DcMotor.Direction.FORWARD);
        rightfront.setDirection(DcMotor.Direction.FORWARD);
        rightback.setDirection(DcMotor.Direction.FORWARD);

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
        double right;
        double left;

        right = -gamepad1.right_stick_y;
        left = -gamepad1.left_stick_y;

        leftback.setPower(left);
        leftfront.setPower(left);
        rightback.setPower(right);
        rightfront.setPower(right);



    }
}
