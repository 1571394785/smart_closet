# 说明
## 元器件
- 1个树莓派Pico W
- 1个OLED屏幕
- 1个湿度传感器
- 1个XY摇杆
- 1个按键
- 1个Hc-05蓝牙模块
- 1个霍尔传感器
- 2个LED灯
## 项目目录说明
```
├─APP //安卓APP
│  └─app
│      └─bluetooth_control
│          ├─.gradle
│          │  ├─7.2
│          │  │  ├─dependencies-accessors
│          │  │  ├─executionHistory
│          │  │  ├─fileChanges
│          │  │  ├─fileHashes
│          │  │  └─vcsMetadata-1
│          │  ├─buildOutputCleanup
│          │  ├─checksums
│          │  └─vcs-1
│          ├─app
│          │  ├─build
│          │  │  ├─generated
│          │  │  │  ├─ap_generated_sources
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─res
│          │  │  │  │  ├─pngs
│          │  │  │  │  │  └─debug
│          │  │  │  │  │      └─drawable-anydpi-v24
│          │  │  │  │  └─resValues
│          │  │  │  │      └─debug
│          │  │  │  └─source
│          │  │  │      └─buildConfig
│          │  │  │          └─debug
│          │  │  │              └─com
│          │  │  │                  └─example
│          │  │  │                      └─myapplication
│          │  │  ├─intermediates
│          │  │  │  ├─aar_metadata_check
│          │  │  │  │  └─debug
│          │  │  │  ├─annotation_processor_list
│          │  │  │  │  └─debug
│          │  │  │  ├─apk
│          │  │  │  │  └─debug
│          │  │  │  ├─apk_ide_redirect_file
│          │  │  │  │  └─debug
│          │  │  │  ├─app_metadata
│          │  │  │  │  └─debug
│          │  │  │  ├─assets
│          │  │  │  │  └─debug
│          │  │  │  │      └─mergeDebugAssets
│          │  │  │  ├─compatible_screen_manifest
│          │  │  │  │  └─debug
│          │  │  │  ├─compile_and_runtime_not_namespaced_r_class_jar
│          │  │  │  │  └─debug
│          │  │  │  ├─compressed_assets
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─data_binding_layout_info_type_merge
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─data_binding_layout_info_type_package
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─desugar_graph
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  │          ├─currentProject
│          │  │  │  │          │  ├─dirs_bucket_0
│          │  │  │  │          │  ├─dirs_bucket_1
│          │  │  │  │          │  ├─dirs_bucket_2
│          │  │  │  │          │  ├─dirs_bucket_3
│          │  │  │  │          │  ├─dirs_bucket_4
│          │  │  │  │          │  ├─dirs_bucket_5
│          │  │  │  │          │  ├─dirs_bucket_6
│          │  │  │  │          │  ├─dirs_bucket_7
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_0
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_1
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_2
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_3
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_4
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_5
│          │  │  │  │          │  ├─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_6
│          │  │  │  │          │  └─jar_0da07cc1e282842eedf16d3e8d7c93d624731b47325cc6a1a01b3617b3698084_bucket_7
│          │  │  │  │          ├─externalLibs
│          │  │  │  │          ├─mixedScopes
│          │  │  │  │          └─otherProjects
│          │  │  │  ├─dex
│          │  │  │  │  └─debug
│          │  │  │  │      ├─mergeExtDexDebug
│          │  │  │  │      ├─mergeLibDexDebug
│          │  │  │  │      │  ├─0
│          │  │  │  │      │  ├─1
│          │  │  │  │      │  ├─10
│          │  │  │  │      │  ├─11
│          │  │  │  │      │  ├─12
│          │  │  │  │      │  ├─13
│          │  │  │  │      │  ├─14
│          │  │  │  │      │  ├─15
│          │  │  │  │      │  ├─2
│          │  │  │  │      │  ├─3
│          │  │  │  │      │  ├─4
│          │  │  │  │      │  ├─5
│          │  │  │  │      │  ├─6
│          │  │  │  │      │  ├─7
│          │  │  │  │      │  ├─8
│          │  │  │  │      │  └─9
│          │  │  │  │      └─mergeProjectDexDebug
│          │  │  │  │          ├─0
│          │  │  │  │          ├─1
│          │  │  │  │          ├─10
│          │  │  │  │          ├─11
│          │  │  │  │          ├─12
│          │  │  │  │          ├─13
│          │  │  │  │          ├─14
│          │  │  │  │          ├─15
│          │  │  │  │          ├─2
│          │  │  │  │          ├─3
│          │  │  │  │          ├─4
│          │  │  │  │          ├─5
│          │  │  │  │          ├─6
│          │  │  │  │          ├─7
│          │  │  │  │          ├─8
│          │  │  │  │          └─9
│          │  │  │  ├─dex_archive_input_jar_hashes
│          │  │  │  │  └─debug
│          │  │  │  ├─dex_number_of_buckets_file
│          │  │  │  │  └─debug
│          │  │  │  ├─duplicate_classes_check
│          │  │  │  │  └─debug
│          │  │  │  ├─external_file_lib_dex_archives
│          │  │  │  │  └─debug
│          │  │  │  ├─external_libs_dex_archive
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─external_libs_dex_archive_with_artifact_transforms
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─incremental
│          │  │  │  │  ├─debug-mergeJavaRes
│          │  │  │  │  │  └─zip-cache
│          │  │  │  │  ├─mergeDebugAssets
│          │  │  │  │  ├─mergeDebugJniLibFolders
│          │  │  │  │  ├─mergeDebugResources
│          │  │  │  │  │  ├─merged.dir
│          │  │  │  │  │  └─stripped.dir
│          │  │  │  │  ├─mergeDebugShaders
│          │  │  │  │  ├─packageDebug
│          │  │  │  │  │  └─tmp
│          │  │  │  │  │      └─debug
│          │  │  │  │  │          └─zip-cache
│          │  │  │  │  ├─packageDebugResources
│          │  │  │  │  │  ├─merged.dir
│          │  │  │  │  │  └─stripped.dir
│          │  │  │  │  └─processDebugResources
│          │  │  │  ├─javac
│          │  │  │  │  └─debug
│          │  │  │  │      └─classes
│          │  │  │  │          └─com
│          │  │  │  │              └─example
│          │  │  │  │                  └─myapplication
│          │  │  │  ├─local_only_symbol_list
│          │  │  │  │  └─debug
│          │  │  │  ├─manifest_merge_blame_file
│          │  │  │  │  └─debug
│          │  │  │  ├─merged_java_res
│          │  │  │  │  └─debug
│          │  │  │  ├─merged_jni_libs
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─merged_manifest
│          │  │  │  │  └─debug
│          │  │  │  ├─merged_manifests
│          │  │  │  │  └─debug
│          │  │  │  ├─merged_res
│          │  │  │  │  └─debug
│          │  │  │  ├─merged_res_blame_folder
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  │          ├─multi-v2
│          │  │  │  │          └─single
│          │  │  │  ├─merged_shaders
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─mixed_scope_dex_archive
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─navigation_json
│          │  │  │  │  └─debug
│          │  │  │  ├─packaged_manifests
│          │  │  │  │  └─debug
│          │  │  │  ├─packaged_res
│          │  │  │  │  └─debug
│          │  │  │  │      ├─drawable
│          │  │  │  │      ├─drawable-v24
│          │  │  │  │      ├─layout
│          │  │  │  │      ├─menu
│          │  │  │  │      ├─mipmap-anydpi-v26
│          │  │  │  │      ├─mipmap-hdpi-v4
│          │  │  │  │      ├─mipmap-mdpi-v4
│          │  │  │  │      ├─mipmap-xhdpi-v4
│          │  │  │  │      ├─mipmap-xxhdpi-v4
│          │  │  │  │      ├─mipmap-xxxhdpi-v4
│          │  │  │  │      ├─values
│          │  │  │  │      └─values-night-v8
│          │  │  │  ├─processed_res
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─project_dex_archive
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  │          └─com
│          │  │  │  │              └─example
│          │  │  │  │                  └─myapplication
│          │  │  │  ├─runtime_symbol_list
│          │  │  │  │  └─debug
│          │  │  │  ├─signing_config_versions
│          │  │  │  │  └─debug
│          │  │  │  ├─stable_resource_ids_file
│          │  │  │  │  └─debug
│          │  │  │  ├─sub_project_dex_archive
│          │  │  │  │  └─debug
│          │  │  │  │      └─out
│          │  │  │  ├─symbol_list_with_package_name
│          │  │  │  │  └─debug
│          │  │  │  └─validate_signing_config
│          │  │  │      └─debug
│          │  │  ├─outputs
│          │  │  │  └─logs
│          │  │  └─tmp
│          │  │      └─compileDebugJavaWithJavac
│          │  ├─libs
│          │  └─src
│          │      ├─androidTest
│          │      │  └─java
│          │      │      └─com
│          │      │          └─example
│          │      │              └─myapplication
│          │      ├─main
│          │      │  ├─java
│          │      │  │  └─com
│          │      │  │      └─example
│          │      │  │          └─myapplication
│          │      │  └─res
│          │      │      ├─drawable
│          │      │      ├─drawable-v24
│          │      │      ├─layout
│          │      │      ├─menu
│          │      │      ├─mipmap-anydpi-v26
│          │      │      ├─mipmap-hdpi
│          │      │      ├─mipmap-mdpi
│          │      │      ├─mipmap-xhdpi
│          │      │      ├─mipmap-xxhdpi
│          │      │      ├─mipmap-xxxhdpi
│          │      │      ├─values
│          │      │      └─values-night
│          │      └─test
│          │          └─java
│          │              └─com
│          │                  └─example
│          │                      └─myapplication
│          └─gradle
│              └─wrapper
├─元器件资料
│  └─0.96OLED显示屏数据手册
├─原理图
├─程序源码
│  └─代码
│      └─1
│          └─.vscode
├─系统框图
└─设计报告
```
## 运行环境
- Windows 10
- Android Studio 3.5.3
- Thonny 3.2.7
