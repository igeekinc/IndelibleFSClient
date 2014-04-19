// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.igeekinc.indelible.indeliblefs.events;

public final class RemoteIndelibleEventIteratorImpl_Stub
    extends java.rmi.server.RemoteStub
    implements com.igeekinc.indelible.indeliblefs.events.RemoteIndelibleEventIterator, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("void close()"),
	new java.rmi.server.Operation("boolean hasNext()"),
	new java.rmi.server.Operation("com.igeekinc.indelible.indeliblefs.events.IndelibleEvent next()"),
	new java.rmi.server.Operation("void remove()")
    };
    
    private static final long interfaceHash = 7379287529964264163L;
    
    // constructors
    public RemoteIndelibleEventIteratorImpl_Stub() {
	super();
    }
    public RemoteIndelibleEventIteratorImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of close()
    public void close()
	throws java.rmi.RemoteException
    {
	try {
	    java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
	    ref.invoke(call);
	    ref.done(call);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of hasNext()
    public boolean hasNext()
	throws java.rmi.RemoteException
    {
	try {
	    java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 1, interfaceHash);
	    ref.invoke(call);
	    boolean $result;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$result = in.readBoolean();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling return", e);
	    } finally {
		ref.done(call);
	    }
	    return $result;
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of next()
    public com.igeekinc.indelible.indeliblefs.events.IndelibleEvent next()
	throws java.rmi.RemoteException
    {
	try {
	    java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 2, interfaceHash);
	    ref.invoke(call);
	    com.igeekinc.indelible.indeliblefs.events.IndelibleEvent $result;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$result = (com.igeekinc.indelible.indeliblefs.events.IndelibleEvent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling return", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling return", e);
	    } finally {
		ref.done(call);
	    }
	    return $result;
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of remove()
    public void remove()
	throws java.rmi.RemoteException
    {
	try {
	    java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 3, interfaceHash);
	    ref.invoke(call);
	    ref.done(call);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
