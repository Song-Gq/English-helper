﻿# English-helper
## 已知问题
* **语音合成部分调用的是铃声声音而不是媒体声音**  
* （不再重要）设置电话号码时的输入框，若已有内容，光标会在开始处而不是结束处  
* （不再重要）UI的进一步更新，包括动画  
## 历史  
* 6/11  
添加了新功能。例：搜一下O-R-A-N-G-E  
* 6/11  
现在，在设置界面使用返回键或点击窗口之外的区域也会显示号码未更改的提示了。  
* 6/11  
现在，第一个功能点也会把英文单词复制到剪贴板了。  
* 6/10  
自动申请麦克风权限  
* 6/10  
延长了“单词已复制到剪贴板”的通知持续时间。  
略微优化了语义判断。  
现在单词本身和单词释义分行显示了。  
* 6/10  
本次app下build.gradle的dependencies应加一行implementation 'com.android.support:design:27.1.1'。  
实现了每日一词的功能点。含有“词”即可触发。单词会自动复制到剪贴板。约1000的专八词库。仅读单词本身。  
更新了图标，支持安卓9.0移动时的动画特性。  
更新了帮助和设置按钮，现在会显示帮助内容。  
保存或取消设置号码会在底部有消息弹出。  
修复了文字闪现的错误。  
* 6/9  
直接在素材上添加了阴影。  
增强了说话按钮按下的视觉反馈。  
现在，按下说话按钮后会直接清除未显示完全的文字动画。  
* 6/9  
对UI进行了更新，含有新的素材。  
语音识别部分指令增多。现在用string.xml中keywords_pre+中文+keywords_post可以触发第一个功能点，仅有pre或post也可。  
修复了没有网络和麦克风权限闪退的问题。  
砍掉了帮助按钮，通过欢迎语实现。  
* 6/2  
修复连点两次语音按钮闪退。  
修复“我想查询”没有查询内容的闪退。  
* 6/2  
只有更改过的文件被上传了。  
同时含有”电话“和“老师”的指令可以出发该功能。  
加入了一个"Settings"和一个"Help"按钮。  
设置按钮可以输入电话并保存。  
* 6/1  
应用主体和第一个功能点。  
