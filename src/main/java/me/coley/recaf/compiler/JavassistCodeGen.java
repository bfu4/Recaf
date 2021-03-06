package me.coley.recaf.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.JvstCodeGen;
import me.coley.recaf.workspace.Workspace;

/**
 * Modified code generator for Javassist to pull information from Recaf.
 *
 * @author Matt
 */
public class JavassistCodeGen extends JvstCodeGen {
	/**
	 * @param workspace
	 * 		Workspace to pull class information from.
	 * @param bytecode
	 * 		Target generated bytecode wrapper.
	 * @param declaringClass
	 * 		Class containing the method our expression resides in.
	 * @param classPool
	 * 		Class pool to use.
	 */
	public JavassistCodeGen(Workspace workspace, Bytecode bytecode, CtClass declaringClass, ClassPool classPool) {
		super(bytecode, declaringClass, classPool);
		setTypeChecker(new JavassistTypeChecker(workspace, declaringClass, classPool, this));
		resolver = new JavassistMemberResolver(workspace, classPool);
	}
}
