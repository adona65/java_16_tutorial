package tutorial_000.languageNewFeatures;

public class _003_JvmChanges {
	/*
	 * Java 16 delivered various changes concerning JVM. Here are some.
	 */
	
	/*
	 * Garbage Collectors
	 * 
	 * Java 15 has made the ZGC (Z Garbage Collector) a standard feature. With Java 16, ZGC Thread-Stack processing is enhanced :
	 * - Thread-stack processing moved from ZGC safepoints to Concurrent Phase
	 * - Stack processing is made lazy, cooperative, concurrent, and incremental
	 * - All other per-thread root processing are removed from ZGC safepoints
	 * - HotSpot subsystems can lazily process stacks
	 */
	
	/*
	 * Migrate from Mercurial to GitHub
	 * 
	 * OpenJDK Source code is moved from Mercurial to Git/GitHub for some reasons :
	 * - Large File size of version control system metadata (Mercurial)
	 * - Available tooling
	 * - Available hosting
	 */
}
