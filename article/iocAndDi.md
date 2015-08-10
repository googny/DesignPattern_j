# 控制反转和依赖注入 #
## 控制反转（IOC） ##

在使用非IOC范式编程时，程序逻辑的流程通常是由一个功能中心来控制的。如果设计的好，这个功能中心会调用各个重用对象中的方法执行特定的功能。  

使用IOC，这个“中心控制”的设计原则会被反转过来。调用者的代码处理程序的执行顺序，而程序逻辑被封装在接受调用的子流程中。  

IOC又称为**好莱坞模式** ，其思想可以归结为有另一段代码拥有最初的控制线程，并且由它来调用你的代码，而不是由你的代码调用它。  

IOC有几种不同的实现：工厂模式、服务定位器模式和依赖注入。  

## 依赖注入(DI) ##

依赖注入是IOC的一种特定形态，是指寻找依赖项的过程不再当前执行代码的直接控制之下。一般都会使用自带IOC容器的第三方DI框架，虽然你也可以自己实现依赖注入机制。  

###使用DI的好处  
1、 松耦合， 你的代码不再紧紧绑定到依赖项的创建上了，如果能与**面向接口编程的技术**相结合，意味着你的代码不再紧紧地绑定到依赖项的具体实现上了。  
2、 易测性， 为了测试，可以将测试替身（**存根类**）作为依赖项注入到对象中。  
3、 更强的内聚性， 你的代码可以专注于执行自己的任务，不用为了载入和配置依赖项而分心。也增强了代码可读性。  
4、 可重用组件， 作为松耦合的眼神，你的代码应用范围更加宽广，那些可以提供自己 **特定实现** (因为你的代码已经和实现完全解耦了)的用户都可以使用你的代码。  
5、 更轻盈的代码， 你的代码不再需要跨层传递依赖项，而是可以在需要依赖项的地方直接注入。  

## 举个栗子 ##
*例子来源：Java程序员修炼之道，第三章，第一节*  
**不用IOC的代码-->使用工厂模式的代码-->编程使用DI的代码-->DI框架的代码**  

定义`AgentFinder`接口,该接口有两个类：`SpreadsheetAgentFinder`和`WebServiceAgentFinder`  

	public interface AgentFinder {	
		public List<Agent> findAllAgents();
	}
	public class SpreadsheetAgentFinder implements AgentFinder {
		public List<Agent> findAllAgents(){ ... }
	}
	
	public class WebServieAgentFinder implements AgentFinder {
		public List<Agent> findAllAgents(){ ... }
	}

下面定义调用代码，从AgentFinder里得到一个经纪人列表并对列表进行过滤，最终返回符合过滤条件的经纪人列表。  

	public class HollywoodService {
		public static List<Agent> getFriendlyAgents () {
			AgentFinder finder = new SpreadsheetAgentFinder();
			List<Agent> agents = finder.findAllAgents();
			List<Agent> friendlyAgents = filterAgents(agnets,"Java Engineer");
			return friendlyAgents;
		}
	}
仔细看上面的代码，`AgentFinder`的实现类`SpreadsheetAgentFinder`和调用代码紧紧黏在一起。不好(｡•ˇ‸ˇ•｡)  

**1、使用工厂模式的`HollywoodService`**  
抽象工厂、工厂方法或服务定位器模式中的某个通常是用来解决**调用代码被依赖项黏上的问题**  

	public class HollywoodService {
		public static List<Agent> getFriendlyAgents (String agentFinderType) {
			AgentFinderFactory factory = AgentFinderFactory.getInstance();
			AgentFinder finder = factory.getAgentFinder(agentFinderType);
			List<Agent> agents = finder.findAllAgents();
			List<Agent> friendlyAgents = filterAgents(agnets,"Java Engineer");
			return friendlyAgents;
		}
	}

问题： 
> 代码中注入的是一个`agentFinderType`（方法参数），而不是`AgentFinder`的实现。  
> 随着`getFriendlyAgents`中还有获取其依赖项的代码，达不到只关注自身职能的理想状态。  

**2、使用DI的`HollywoodService`**

	public class HollywoodService {
		public static List<Agent> getFriendlyAgents (AgentFinder finder) {
			List<Agent> agents = finder.findAllAgents();
			List<Agent> friendlyAgents = filterAgents(agnets,"Java Engineer");
			return friendlyAgents;
		}
	}

上面的代码是纯手工打造的DI方案，`AgentFinder` 被直接注入到`getFriendlyAgents` 方法中。

问题：
> 如何配置`AgentFinder`具体实现的问题并没有解决，还是得自己实现一个工厂。  

**3、使用JSR-330 DI 的 `HollywoodService`**  

	public class HollywoodService {
		@Inject public static List<Agent> getFriendlyAgents (AgentFinder finder) {
			List<Agent> agents = finder.findAllAgents();
			List<Agent> friendlyAgents = filterAgents(agnets,"Java Engineer");
			return friendlyAgents;
		}
	}
这就很方便了，可以在逻辑代码里直接使用依赖项了，而不用被依赖项黏住了。O(∩_∩)O~~