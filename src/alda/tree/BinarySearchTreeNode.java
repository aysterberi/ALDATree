package alda.tree;

/**
 * Copyright (C) Billy G. J. Beltran (bibe1744) & Joakim Berglund (jobe7147)
 * Contact details: billy@caudimordax.org, joakimberglund@live.se
 */

/**
 * Denna klass representerar noderna i ett binärt sökträd utan dubletter.
 * <p>
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) De ändringar som är tillåtna är dock
 * begränsade av följande regler:
 * <ul>
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * </ul>
 *
 * @param <T>
 * @author henrikbe
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {

    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }

    /**
     * Lägger till en nod i det binära sökträdet. Om noden redan existerar så
     * lämnas trädet oförändrat.
     *
     * @param data datat för noden som ska läggas till.
     * @return true om en ny nod lades till trädet.
     */
    public boolean add(T data) {

        if (data.equals(this.data) || data == this.data) {
            return false;
        } else if (data.compareTo(this.data) < 0) {
            if (this.left == null) {
                left = new BinarySearchTreeNode<>(data);
                return true;
            } else {
                return left.add(data);
            }
        } else if (data.compareTo(this.data) > 0) {
            if (this.right == null) {
                right = new BinarySearchTreeNode<>(data);
                return true;
            } else {
                return right.add(data);
            }
        }
        return false;
    }

    /**
     * Privat hjälpmetod som är till nytta vid borttag. Ni behöver inte
     * skriva/utnyttja denna metod om ni inte vill.
     *
     * @return det minsta elementet i det (sub)träd som noden utgör root i.
     */
    private T findMin() {
        if (left == null) {
            return data;
        } else {
            return left.findMin();
        }
    }

    private boolean isNull(T data) {
        return (data == null) || data.equals(null);
    }

    private boolean hasChildren() {
        return (left != null && right != null);
    }

    private boolean dataEquals(T Data) {
        return (this.data.equals(data) || this.data == data);
    }

    private boolean hasLeft() {
        return left != null;
    }

    private boolean hasRight() {
        return right != null;
    }

    private void clear() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Tar bort ett element ur trädet. Om elementet inte existerar s lämnas
     * trädet oförändrat.
     *
     * @param data elementet som ska tas bort ur trädet.
     * @return en referens till nodens subträd efter borttaget.
     */
    public BinarySearchTreeNode<T> remove(T data) {
        if (!contains(data)) {
//            throw new NullPointerException();
            return this; // return whole tree, there's nothing
        }

        if (data.compareTo(this.data) < 0) {
            if (hasLeft()) {
                return left.remove(data);
            } else {
                return this;
            }
        }
        else if (data.compareTo(this.data) > 0) {
            if (hasRight()) {
                return right.remove(data);
            } else {
                return this;
            }
        }
        else {
            if (hasChildren())
            {
                this.data = right.findMin();
                return right.remove(this.data);
            }
        }
        return this;
    }

    /**
     * Kontrollerar om ett givet element finns i det (sub)träd som noden utgör
     * root i.
     *
     * @param data det sökta elementet.
     * @return true om det sökta elementet finns i det (sub)träd som noden utgör
     * root i.
     */
    public boolean contains(T data) {
        if (data.equals(this.data) || data == this.data) {
            return true;
        } else if (data.compareTo(this.data) < 0) {
            return this.left.contains(data);
        } else if (data.compareTo(this.data) > 0) {
            return this.right.contains(data);
        }
        return false;
    }

    /**
     * Storleken på det (sub)träd som noden utgör root i.
     *
     * @return det totala antalet noder i det (sub)träd som noden utgör root i.
     */
    public int size() {
        if ((left == null) && (right == null)) {
            return 1;
        }
        if ((left != null) && (right != null)) {
            return 1 + left.size() + right.size();
        }
        if (left != null && (right == null)) {
            return 1 + left.size();
        } else if (left == null && (right != null)) {
            return 1 + right.size();
        }
        return 1;
    }

    /**
     * Det högsta djupet i det (sub)träd som noden utgör root i.
     *
     * @return djupet.
     */
    public int depth() {
        if (left == null && right == null) {
            return 0;
        } else if (left != null && right != null) {
            return 1 + recursiveDepth();
        } else if (left == null) {
            return 1 + right.depth();
        } else if (right == null) {
            return 1 + left.depth();
        }

        return -1;
    }

    private int recursiveDepth() {
        return Math.max(left.depth(), right.depth());
    }

    /**
     * Returnerar en strängrepresentation för det (sub)träd som noden utgör root
     * i. Denna representation består av elementens dataobjekt i sorterad
     * ordning med ", " mellan elementen.
     *
     * @return strängrepresentationen för det (sub)träd som noden utgör root i.
     */
    public String toString() {
        return "";
    }
}
