public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        InputConnectable projectorInput = reg.getFirstByCapabilities(InputConnectable.class, PowerControllable.class);
        ((PowerControllable) projectorInput).powerOn();
        projectorInput.connectInput("HDMI-1");

        BrightnessControllable lights = reg.getFirstByCapabilities(BrightnessControllable.class, PowerControllable.class);
        lights.setBrightness(60);

        TemperatureControllable ac = reg.getFirstByCapabilities(TemperatureControllable.class, PowerControllable.class);
        ac.setTemperatureC(24);

        AttendanceScannable scan = reg.getFirstByCapabilities(AttendanceScannable.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirstByCapabilities(PowerControllable.class, InputConnectable.class).powerOff();
        reg.getFirstByCapabilities(PowerControllable.class, BrightnessControllable.class).powerOff();
        reg.getFirstByCapabilities(PowerControllable.class, TemperatureControllable.class).powerOff();
    }
}
