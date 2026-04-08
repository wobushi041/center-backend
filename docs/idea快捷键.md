# IDEA 快捷键

## 使用说明
- 所有快捷键均针对 Windows 版 IntelliJ IDEA，记法遵循 Ctrl → Alt → Shift 的顺序。
- “（原 …）”表示官方默认键位，目前在本地被替换为前述自定义键，方便跨设备查找。
- 代码标识符、命令与快捷键保持原语言；语义解释为中文，输入表达式时直接敲 `!` 即可完成逻辑非。

## 1. 编辑与输入
### 1.1 代码补全与模板
- `Ctrl+Shift+Enter`：语句完成，自动补齐括号与分号。
- `Ctrl+;`（原 `Ctrl+Space`）：基本代码补全，列出类/方法/变量。
- `Ctrl+Shift+;`（原 `Ctrl+Shift+Space`）：智能补全，按期望类型过滤候选。
- `Ctrl+Alt+Space`：类名自动完成。
- `Ctrl+Alt+T`：用 if/else、try/catch、for、synchronized 等块包围选区。
- `Ctrl+J`：插入 Live Template（例如 psvm、sout、serr）。
- `Ctrl+Alt+J`：使用自定义模板环绕选区。
- `psvm / sout / serr`：输入后按 Tab 自动展开 main 或输出语句。
- `Ctrl+P`：显示当前方法的参数信息。
- `!`：在表达式中直接输入逻辑非，完成“否定”输入。

### 1.2 行、块与选择
- `Shift+Enter`：在当前行下方插入空行。
- `Ctrl+Enter`：智能拆分当前行，或在上方插入新行。
- `Ctrl+Shift+J`：将多行内容合并为一行。
- `Ctrl+W` / `Ctrl+Shift+W`：逐步扩大 / 缩小选区。
- `Ctrl+[ / Ctrl+]`：光标移动到当前代码块的起始 / 结束花括号。
- `Ctrl+Shift+[ / Ctrl+Shift+]`：将选区扩展到代码块起点 / 终点。
- `Ctrl+Shift+Up / Ctrl+Shift+Down`：整句向上 / 向下移动。
- `Alt+Shift+Up / Alt+Shift+Down`：调整当前行位置。
- `Ctrl+Alt+Up / Ctrl+Alt+Down`：复制当前行或选区到上一行 / 下一行（Eclipse Actions 风格）。
- `Alt+D`（原 `Ctrl+D`）：把当前行复制到下一行。
- `Ctrl+X` 或 `Shift+Delete`：剪切（并删除）当前行 / 选区。
- `Ctrl+C` 或 `Ctrl+Insert`：复制当前行 / 选区。
- `Ctrl+V` 或 `Shift+Insert`：粘贴剪贴板内容。
- `Ctrl+Y` / `Ctrl+D`：删除当前行或选区。
- `Ctrl+Shift+U`：大小写互换。
- `Ctrl+Delete` / `Ctrl+Backspace`：删除到单词末尾 / 开头。
- `Ctrl+Alt+Up / Ctrl+Alt+Down`（查找模式）：在搜索结果间跳转。

### 1.3 格式、注释与文档
- `Ctrl+Alt+L`：按代码样式格式化。
- `Ctrl+Alt+I`：自动重新缩进，JSP 同样适用。
- `Ctrl+Alt+O`：优化 import。
- `Tab / Shift+Tab`：控制缩进或退出缩进。
- `Ctrl+/`：切换行为 // 注释。
- `Ctrl+Shift+/`：切换块注释 /* … */。
- `Alt+Enter`：显示意图动作与快速修复（导入包、纠错）。
- `Alt+Q`（原 `Ctrl+Q`）：查看 Quick Documentation。
- `Ctrl+Alt+Q`（原 `Alt+Q`）：显示上下文信息（方法/类声明摘要）。
- `Shift+F1`：在浏览器打开 External Doc。
- `Ctrl+鼠标悬停`：预览类 / 方法 / 变量信息。
- `Ctrl+F1`：查看当前错误或警告的详细说明。

### 1.4 剪贴板与粘贴
- `Ctrl+Shift+Insert`：打开剪贴板历史以便插入。
- `Ctrl+Shift+V`：从最近的剪贴板条目中选择粘贴。
- `Ctrl+Alt+Shift+V`：以纯文本形式“简单粘贴”。

## 2. 导航与定位
### 2.1 文件、结构与视图
- `Ctrl+E`：弹出最近文件列表。
- `Ctrl+Shift+E`：弹出最近更改文件。
- `Shift+Click`：在标签上按住 Shift 单击即可关闭文件。
- `Ctrl+F12`：查看当前文件结构并可按键过滤。
- `Ctrl+N`：按类名定位文件。
- `Ctrl+Shift+N`：按文件名定位。
- `Ctrl+Alt+Shift+N`（亦写作 `Ctrl+Shift+Alt+N`）：按符号（方法、变量）搜索。
- `Double Shift`：Search Everywhere。
- `Ctrl+G`：跳转到指定行（再次输入行号可到行首/行尾）。
- `Alt+Home`：定位到导航栏。
- `Alt+1 / Alt+2 / Alt+6 / Alt+7`：打开项目 / 收藏 / TODO / 结构视图。
- `Alt+F1`：在任意视图定位当前文件或符号。
- `Ctrl+Alt+S`：Settings 对话框。
- `Ctrl+Alt+Shift+S`：Project Structure。
- `Ctrl+Shift+A`：Find Action，搜索所有 IDE 功能。
- `Alt+Shift+Insert`：开启/关闭列选择模式。
- `Alt+Shift+F`：添加到 Favorites。
- `Alt+Shift+I`：用当前 Inspection Profile 检查文件。
- `Ctrl+Alt+Y`：同步文件到磁盘。

### 2.2 历史、标签与布局
- `Ctrl+Alt+Left / Ctrl+Alt+Right`（原 `Alt+Left / Right`）：在编辑器标签间切换。
- `Alt+Left / Alt+Right`（原 `Ctrl+Alt+Left / Right`）：在历史光标位置间后退 / 前进。
- `Ctrl+Tab / Ctrl+Shift+Tab`：在打开的标签和工具窗口间循环。
- `Ctrl+Q`（原 `Ctrl+Shift+Backspace`）：跳转到最近编辑位置。
- `Ctrl+Shift+C`：复制当前文件路径。
- `Ctrl+Alt+Shift+C`：复制引用（Reference）。
- `Alt+Shift+C`：查看最近更改。
- `Shift+Esc`：焦点回到编辑器并隐藏当前工具窗口。
- `F12`：焦点跳到最近使用的工具窗口。
- `Shift+F12`：恢复默认布局。
- `Ctrl+Shift+F12`：最大化 / 还原编辑器。
- `Ctrl+F4` / `Ctrl+Shift+F4`：关闭当前编辑器标签 / 关闭运行、消息等面板。

### 2.3 声明、实现与层次
- `Ctrl+B` 或 `Ctrl+Click`：跳转到声明。
- `Ctrl+Alt+B` / `Ctrl+T`：跳转到实现。
- `Ctrl+Shift+B / F3`：跳转到类型声明。
- `Ctrl+U`：转到父类或父方法。
- `Alt+Up / Alt+Down`：在方法间快速移动。
- `Ctrl+Alt+H`：显示调用层次。
- `Ctrl+H`：类型继承层次图。
- `Ctrl+Shift+H`：方法继承层次图。
- `Ctrl+] / Ctrl+[`：在代码块起止跳转（与 1.2 中的选区操作相辅）。
- `Ctrl+F12`：文件结构（再次列出以强调）。

### 2.4 错误定位
- `F2 / Shift+F2`：定位到下一个 / 上一个错误或警告。

## 3. 搜索、替换与用法分析
- `Ctrl+F`：当前文件查找。
- `Ctrl+L` / `Ctrl+Shift+L`：在查找面板中查找下一个 / 上一个（自定义替代 F3 / Shift+F3）。
- `Ctrl+R`：当前文件替换。
- `Ctrl+Shift+F`：在路径中查找。
- `Ctrl+Shift+R`：在路径中替换（同时也是自定义 Rename 快捷键，注意区分上下文）。
- `Ctrl+Shift+S`：结构化搜索。
- `Ctrl+Shift+M`：结构化替换。
- `Alt+F3`：逐个向下查找相同文本并高亮。
- `Ctrl+Shift+F7`：在当前文件高亮所有匹配文本，Esc 取消。
- `Ctrl+F7`：在当前文件查找用法。
- `Alt+F7`：在全工程查找用法。
- `Ctrl+Alt+F7`：弹出用法列表。
- `Ctrl+Shift+F7`（用法模式）：高亮文件内所有用法并可逐一浏览。
- `Ctrl+Alt+Up / Ctrl+Alt+Down`：在查找结果之间跳转。

## 4. 代码生成、重构与提取
- `Alt+Insert`：生成构造器、Getter/Setter、toString、hashCode/equals 等。
- `Ctrl+O`：Override Methods。
- `Ctrl+I`：Implement Methods。
- `Ctrl+Alt+T`：Surround with。
- `Ctrl+Alt+V / Ctrl+Alt+F / Ctrl+Alt+C / Ctrl+Alt+P / Ctrl+Alt+M`：提取变量、字段、常量、参数、方法。
- `Ctrl+Alt+N`：Inline 方法或变量。
- `Ctrl+Alt+J`：用动态模板包裹代码块。
- `Ctrl+Alt+Shift+T`：重构菜单。
- `Alt+Delete`：Safe Delete。
- `Ctrl+Shift+R`（原 `Shift+F6`）：重命名（Rename）。
- `Shift+F10`（原 `F5`）：复制类 / 文件。
- `F10`（原 `F6`）：移动类 / 文件。
- `Ctrl+Alt+R`：调试阶段重新加载已修改的 class（热替换）。

## 5. 运行、编译与调试
- `Ctrl+F9`：Make Project，编译修改及依赖。
- `Ctrl+Shift+F9`：编译选中的文件 / 模块。
- `Alt+Shift+F10`：选择运行配置。
- `Alt+Shift+F9`：选择调试配置。
- `Shift+F9`（原 `Shift+F10`）：运行当前配置。
- `F9`（原 `Shift+F9`）：以 Debug 模式启动。
- `Ctrl+Shift+F10`：从编辑器上下文运行（如测试、main 方法）。
- `Ctrl+F2`：停止运行 / 调试。
- `Ctrl+F8`：切换行断点。
- `Ctrl+Shift+F8`：查看与管理所有断点。
- `Alt+F10`：调试时定位到断点。
- `Alt+F8`：Evaluate Expression。
- `Alt+F9`：Run to Cursor。
- `Ctrl+Alt+F9`：Force Run to Cursor。
- `F6`（原 `F8`）：Step Over。
- `F5`（原 `F7`）：Step Into。
- `Alt+Shift+F7`：Force Step Into。
- `Shift+F7`：Smart Step Into。
- `F7`（原 `Shift+F8`）：Step Out。
- `Alt+Shift+F8`：Force Step Over。
- `F8`（原 `F9`）：Resume Program。
- `Ctrl+Alt+R`：调试时重新加载已改动的 class（热替换，与重构章节呼应）。

## 6. 工具窗口、布局与同步
- `Alt+#（0-9）`：打开对应编号的工具窗口。
- `Alt+1 / Alt+2 / Alt+6 / Alt+7`：项目 / 收藏 / TODO / 结构面板（与 2.1 相同，便于快速查阅）。
- `Alt+Shift+C`：最近更改。
- `Ctrl+Shift+C`：复制路径。
- `Ctrl+Alt+Shift+C`：复制引用。
- `Shift+Esc`：焦点移到编辑器并隐藏窗口。
- `F12`：焦点回到最近的工具窗口。
- `Shift+F12`：恢复默认布局。
- `Ctrl+Shift+F12`：隐藏 / 恢复所有窗口（最大化编辑器）。
- `Ctrl+F4` / `Ctrl+Shift+F4`：关闭当前标签 / 关闭运行、消息等面板。
- `Ctrl+S`：保存全部文件。
- `Ctrl+Alt+Y`：同步文件到磁盘（再次强调）。
- `Ctrl+BackQuote (~)`：快速切换主题、代码风格、快捷键方案。
- `Ctrl+Alt+S` / `Ctrl+Alt+Shift+S`：Settings / Project Structure 快捷键集合。
- `Ctrl+Shift+A`：Find Action（在工具窗口模式下同样适用）。

## 7. Live Template 缩写速查
- `psvm`：public static void main。
- `sout`：System.out.println。
- `serr`：System.err.println。
- `psf`：public static final 常量。
- `thr`：throw new ...。
- `inst`：instanceof 判断与向下转型。
- `iter`：for-each 迭代集合。
- `itco`：遍历 java.util.Collection。
- `itli`：遍历 List。
- `itit`：遍历 Iterator。
