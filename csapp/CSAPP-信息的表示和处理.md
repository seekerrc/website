## 信息存储

大部分计算机使用8位的块（或者字节）来作为最小的可寻址的存储器单元。机器级程序将存储器视为一个非常大的字节数组，称之为虚拟存储器。存储器中的每一个字节由唯一的一个地址（address）来标识，所有可能地址的集合称之为虚拟地址空间（virtual address space）

一切程序及其数据在内存中本质上都是字节，更深层地，物理层面上都是二极管的01开关状态，这也是机器对程序的认识。

### 十六进制表示法
一个字节有8位，用二进制表示就是 00000000(2)-11111111(2) ，用十进制表示是0(10)-256(10)，用十六进制表示是00(16)-FF(16)

### 字
每台计算机都有一个字长（word size），指明整数和指针数据的标称大小（nominal size），字长决定系统中最重要的参数就是虚拟地址空间的最大大小

32位的机器虚拟地址空间最大为4GB，64位机器最大为16EB

### 数据大小
计算机和编译器使用不同的方式来编码数字，比如说不同长度的整数和浮点数，从而支持多种数据格式。注意指针类型，32位机器指针4B，64位机器则是8B，因为存的是虚拟地址

<img src="./assets/截屏2023-01-11 下午8.55.35.png" alt="截屏2023-01-11 下午8.55.35" style="zoom: 50%;" />

程序员应该力图使他们的程序在不同的计算机和编译器上可移植，可移植的其中一个方面就是**使程序对不同的数据类型的确切大小不那么敏感**

例如go语言中对数据类型的指定，只不过一般就用那两个类别😇

> Go's integer types are: `uint8`, `uint16`, `uint32`, `uint64`, `int8`, `int16`, `int32` and `int64.` 
>
> 8, 16, 32 and 64 tell us how many bits each of the types use. 
>
> In addition there two alias types: `byte` which is the same as `uint8` and `rune` which is the same as `int32`.
>
> Go has two floating point types: `float32` and `float64` (also often referred to as single precision and double precision respectively) 

### 寻址和字节顺序

对于跨多个字节的程序对象，我们必须建立两个规则：这个对象的地址是什么；我们怎样在存储器中对这些字节进行排序

> **小端法**：低地址存低位字节，高地址存高位字节
>
> **大端法**：低地址存高位字节，高地址存低位字节

对于一个十六进制的数0x01234567：

<img src="./assets/截屏2023-01-11 下午9.25.19.png" alt="截屏2023-01-11 下午9.25.19" style="zoom:50%;" />

几种机器所使用的字节顺序会成为问题的情况：

* 在不同类型的机器之间通过网络传送二进制数据。
* 当阅读表示整数数据的字节序列时，字节顺序也很重要。
* 当编写规避正常的类型的系统时。

### 表示字符串
C中的字符串被编码为一个以null（其值为0）字符结尾的字符数组

### 表示代码
不同的机器类型使用的是不同的并且不兼容的指令和编码方式，所以最后的二进制代码是有很强的平台依赖性的，其很少能够在不同的操作系统和机器之间进行移植

### C中的位级运算
包括按位与、按位或、异或运算，位运算的一个常见应用就是实现掩码运算（从一个字中选出一个组位）

### C中的逻辑运算
包括逻辑或、逻辑与、逻辑非
逻辑运算表达式中，第一个参数能够确定表达式的结果的时候，逻辑运算表达式就不会计算第二个参数的值

### C中的移位运算
向左移位运算右端补0
向右移位运算包含两种形式：逻辑移位（左端补0）和算数移位（左端补最高有效位）

## 整数表示

### 整型数据类型

<img src="./assets/截屏2023-01-11 下午9.38.35.png" alt="截屏2023-01-11 下午9.38.35" style="zoom:50%;" />

### 无符号和二进制补码编码

假设一共有 w 位，每个介于 0 ~ 2^w -1 之间的数都有唯一一个 w 位的值编码，即这个函数映射是一个双射。

补码表示的是字的最高有效位解释为负权(negative weight)。

### 有符号数和无符号数之间的转换
<img src="./assets/截屏2023-01-11 下午9.43.49.png" alt="截屏2023-01-11 下午9.43.49" style="zoom:50%;" />

### C中的有符号数和无符号数

C 语言允许无符号数和有符号数之间的转换。转换的原则是底层的位表示保持不变。

### 扩展一个数字的位表示
零扩展： 将一个**无符号数**转换为一个更大的数据类型，在开头加0
符号扩展： 将一个**二进制补码**转化为一个更大的数据类型，在开头加最高有效位

### 截断数字
截断一个数字可能会改变它的值——溢出的一种形式

### 有关有符号数和无符号数的建议

有符号数到无符号数的隐式强制类型转换导致了某些非直观的行为。而这些非直观的特性经常导致程序错误，并且这种包含隐式强制类型转换细微差别的错误很难被发现。

> Expression containing signed and unsigned int: **int is cast to unsigned!!**

避免这类错误的一种方法就是绝**不使用无符号数**。实际上，除了 C 以外，很少有语言支持无符号整数。

无符号数应用场景：标志位、地址、部分数学运算

## 整数运算

### 无符号加法
每个数都能表示为 w 位无符号数字。如果计算它们的和，表示这个和可能需要 w + 1位。无符号运算可以被视为一种模运算形式。
<img src="./assets/截屏2023-01-11 下午9.50.46.png" alt="截屏2023-01-11 下午9.50.46" style="zoom:50%;" />

<img src="./assets/截屏2023-01-11 下午9.49.52.png" alt="截屏2023-01-11 下午9.49.52" style="zoom:50%;" />

### 二进制补码加法

必须确定当结果太大(为正)或者太小(为负)时，应该做些什么。

<img src="./assets/截屏2023-01-11 下午9.52.11.png" alt="截屏2023-01-11 下午9.52.11" style="zoom:50%;" />

<img src="./assets/截屏2023-01-11 下午9.52.29.png" alt="截屏2023-01-11 下午9.52.29" style="zoom:50%;" />

<img src="./assets/截屏2023-01-11 下午9.53.16.png" alt="截屏2023-01-11 下午9.53.16" style="zoom:50%;" />

### 乘法

无符号数乘法，直接截取最低位。二进制补码乘法在前者结果的二进制编码基础上重新解析为补码。两者编码相同（Bit-level equivalence）

<img src="./assets/截屏2023-01-11 下午9.56.16.png" alt="截屏2023-01-11 下午9.56.16" style="zoom:50%;" />

### 乘以2的幂

在大多数机器上，整数乘法指令相当慢，需要 10 个或者更多的时钟周期，然而其他整数运算(例如加法、减法、位级运算和移位)只需要 1 个时钟周期。

因此，编译器使用了一项重要的优化，试着用移位和加法运算的组合来代替乘以常数因子的乘法。

### 除以2的幂

在大多数机器上，整数除法要比整数乘法更慢——需要 30 个或者更多的周期。除以 2 的幂也可以用移位运算右移来实现，无符号和补码数分别使用逻辑移位和算术移位来达到目的。

## 浮点

### 二进制小数
<img src="./assets/截屏2023-01-11 下午10.04.04.png" alt="截屏2023-01-11 下午10.04.04" style="zoom:50%;" />

### IEEE浮点表示

$$
\begin{equation}
V=(-1)^S \times M \times 2^E
\end{equation}
$$

* 符号(sign) s决定这个数是负数(s=1)还是正数(s=0)，对于数值 0 的符号位解释作为特殊情况处理。
* 尾数(significand) M 是一个二进制小数，它的范围是 1 ~ 2 - ε，或者是 0 ~ 1 - ε。
* 阶码(exponent) E 的作用是对浮点数加权，这个权重是 2 的 E 次幂(可能是负数)

将浮点数的位表示划分为三个字段，分别对这些值进行编码：
* 一个单独的符号位 s 直接编码符号 s。

* k 位的阶码字段 exp = e(k-1)…e(1)e(0) 编码阶码 E。

* n 位小数字段 frac = f(n-1)…f(1)f(0) 编码尾数 M，但是编码出来的值也依赖于阶码字段的值是否等于 0。

  <img src="./assets/截屏2023-01-11 下午10.07.44.png" alt="截屏2023-01-11 下午10.07.44" style="zoom:50%;" />

<img src="./assets/截屏2023-01-11 下午10.09.14.png" alt="截屏2023-01-11 下午10.09.14" style="zoom:50%;" />

> *Denormalized numbers serve two purposes.*
>
> *First, they provide a way to represent numeric value 0*
>
> *A second function of denormalized numbers is to represent numbers that are very close to 0.0.*

<img src="./assets/截屏2023-01-11 下午10.12.43.png" alt="截屏2023-01-11 下午10.12.43" style="zoom:50%;" />

### 舍入

因为表示方法限制类浮点数的范围和精度，浮点运算只能近似地表示实数运算。因此，对于值 x，我们一般想用一种系统的方法，能够找到最接近的匹配值，这就是舍入运算的任务

常见的舍入方式有：向偶数舍入、向零舍入、向下舍入、向上舍入

<img src="./assets/截屏2023-01-11 下午10.13.44.png" alt="截屏2023-01-11 下午10.13.44" style="zoom:50%;" />

### 浮点运算

浮点加法符合交换律，但是不具有结合性。

> ***not associative**. For example, with single precision*
>
> *floating point the expression* ***(3.14+1e10)-1e10* *evaluates to* *0.0***—the value 3.14 is lost due to rounding. 
>
> *On the other hand, the expression* ***3.14+(1e10-1e10)* *evaluates to* *3.14*.**
>
> note：try it in Python(double precision by default) and you will get different result

浮点乘法在加法上不具备分配性。

对于科学计算程序员和编译器编写者来说，这是很严重的问题，即使为了在三维空间中确定两条线是否交叉而写代码这样看上去很简单的任务，也可能成为一个很大的挑战。

### C语言的浮点数

float 和 double。在 int、float 和 double 格式之间进行强制类型转换时，程序改变数值和位模式的原则如下(假设 int 是 32 位的)：
* 从 int 转换成 float，不会溢出，可能被舍入。
* 从 int 或 float 转换成 double，能够保留精确的数值。
* 从 double 转换成 float，可能溢出成为正无穷或负无穷，也可能被舍入。
* 从 float 或者 double 转换成 int，值会向零舍入。例如 1.999 将被转换成 1。

## 总结

在二进制运算中遵守交换律、结合律、分配律意味着可以在编译器层面上对运算进行等值转换，优化运算速度，减少所需时钟次数

浮点数存储的编码可能是对实数的近似数值，在涉及到高精度运算需求时需要特别注意误差问题
