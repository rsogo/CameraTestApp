package jp.co.ncdc.cameratestapp

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CameraMetadata
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        exifTestButton.setOnClickListener {
            //ExifHelper.saveExif("002_20180222170535_OS4.jpg", "new.jpg")

            log_text.text = getSupportedHardwareLevel()
        }
    }

    fun getSupportedHardwareLevel(): String {

        var result = ""

        if (Build.VERSION_CODES.LOLLIPOP <= Build.VERSION.SDK_INT) {
            // カメラマネージャのインスタンスを取得
            var manager = getSystemService(Context.CAMERA_SERVICE)
            if (manager is CameraManager) {
                for (cameraId in manager.cameraIdList) {

                    val characteristics = manager.getCameraCharacteristics(cameraId)

                    result = "checking SUPPORTED_HARDWARE_LEVEL\nINFO_SUPPORTED_HARDWARE_LEVEL = "
                    val deviceLevel = characteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)

                    if (deviceLevel == CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY) {
                        result += "LEGACY.\n\n"
                    }
                    if (deviceLevel == CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED) {
                        result += "LIMITED.\n\n"
                    }
                    if (deviceLevel == CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_FULL) {
                        result += "FULL.\n\n"
                    }

//                    result += getCheckResultFlashAvailable(characteristics)
//
//
//                    result += getAvailableAFModes(characteristics)
                }

            }

        } else {

        }
        return result
    }

    fun getCheckResultFlashAvailable(characteristics: CameraCharacteristics): String {
        var isSupport = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
        return "FLASH_INFO_AVAILABLE is " + isSupport + "\n\n"
    }

    fun getAvailableAFModes(characteristics: CameraCharacteristics): String {
        var result = "checking CONTROL_AF_AVAILABLE_MODES\n"
        var availableModes = characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)
        for (mode in availableModes) {
            when (mode) {
                CameraMetadata.CONTROL_AF_MODE_OFF -> {
                    result += "CONTROL_AF_MODE_OFF\n"
                }
                CameraMetadata.CONTROL_AF_MODE_AUTO -> {
                    result += "CONTROL_AF_MODE_AUTO\n"
                }
                CameraMetadata.CONTROL_AF_MODE_CONTINUOUS_PICTURE -> {
                    result += "CONTROL_AF_MODE_CONTINUOUS_PICTURE\n"
                }
                CameraMetadata.CONTROL_AF_MODE_CONTINUOUS_VIDEO -> {
                    result += "CONTROL_AF_MODE_CONTINUOUS_VIDEO\n"
                }
                CameraMetadata.CONTROL_AF_MODE_EDOF -> {
                    result += "CONTROL_AF_MODE_EDOF\n"
                }
                CameraMetadata.CONTROL_AF_MODE_MACRO -> {
                    result += "CONTROL_AF_MODE_MACRO\n"
                }
            }
        }
        return result
    }

}
