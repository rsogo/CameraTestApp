//package jp.co.ncdc.cameratestapp
//
//import android.content.Context
//import android.hardware.camera2.CameraCharacteristics
//import android.hardware.camera2.CameraManager
//import android.hardware.camera2.CameraMetadata
//import android.os.Build
//import jp.co.ncdc.cameratestapp.R.id.log_text
//
//
//fun getSupportedHardwareLevel(characteristics: CameraCharacteristics): String {
//    if (Build.VERSION_CODES.KITKAT >= Build.VERSION.SDK_INT) {
//        // カメラマネージャのインスタンスを取得
//        var manager = getSystemService(Context.CAMERA_SERVICE)
//        if (manager is CameraManager) {
//            for (cameraId in manager.cameraIdList) {
//                log_text.text = getSupportedHardwareLevel(characteristics)
//
//                log_text.text = log_text.text.toString() + getCheckResultFlashAvailable(characteristics)
//
//                log_text.text = log_text.text.toString() + getAvailableAFModes(characteristics)
//            }
//
//        }
//
//        val characteristics = manager.getCameraCharacteristics(cameraId)
//
//
//        var result = "checking INFO_SUPPORTED_HARDWARE_LEVEL.\n"
//        val deviceLevel = characteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)
//
//        if (deviceLevel == CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY) {
//            result += "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY.\n"
//        }
//        if (deviceLevel == CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED) {
//            result += "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED.\n"
//        }
//        if (deviceLevel == CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_FULL) {
//            result += "INFO_SUPPORTED_HARDWARE_LEVEL_FULL.\n"
//        }
//    } else {
//
//    }
//    return result
//}
//
//fun getCheckResultFlashAvailable(characteristics: CameraCharacteristics): String {
//    var isSupport = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
//    return "FLASH_INFO_AVAILABLE is " + isSupport + "\n"
//}
//
//fun getAvailableAFModes(characteristics: CameraCharacteristics): String {
//    var result = "checking CONTROL_AF_AVAILABLE_MODES\n"
//    var availableModes = characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)
//    for (mode in availableModes) {
//        when (mode) {
//            CameraMetadata.CONTROL_AF_MODE_OFF -> {
//                result += "CONTROL_AF_MODE_OFF\n"
//            }
//            CameraMetadata.CONTROL_AF_MODE_AUTO -> {
//                result += "CONTROL_AF_MODE_AUTO\n"
//            }
//            CameraMetadata.CONTROL_AF_MODE_CONTINUOUS_PICTURE -> {
//                result += "CONTROL_AF_MODE_CONTINUOUS_PICTURE\n"
//            }
//            CameraMetadata.CONTROL_AF_MODE_CONTINUOUS_VIDEO -> {
//                result += "CONTROL_AF_MODE_CONTINUOUS_VIDEO\n"
//            }
//            CameraMetadata.CONTROL_AF_MODE_EDOF -> {
//                result += "CONTROL_AF_MODE_EDOF\n"
//            }
//            CameraMetadata.CONTROL_AF_MODE_MACRO -> {
//                result += "CONTROL_AF_MODE_MACRO\n"
//            }
//        }
//    }
//    return result
//}