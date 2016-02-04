package alda.tree;

/**
  Copyright (C) Billy G. J. Beltran (bibe1744) & Joakim Berglund (jobe7147)
  Contact details: billy@caudimordax.org, joakimberglund@live.se
 */

/**
 * Denna klass representerar noderna i ett binärt sökträd utan dubletter.
 *
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
 * @author henrikbe
 *
 * @param <T>
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
     *
     * @return true om en ny nod lades till trädet.
     */
    public boolean add(T data) {

        if(data.equals(this.data) || data == this.data) {
            return false;
        } else if(data.compareTo(this.data) < 0) {
            if(this.left == null) {
                left = new BinarySearchTreeNode<>(data);
                return true;
            } else {
                return left.add(data);
            }
        } else if(data.compareTo(this.data) > 0) {
            if(this.right == null) {
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

    /**
     * Tar bort ett element ur trädet. Om elementet inte existerar s lämnas
     * trädet oförändrat.
     *
     * @param data elementet som ska tas bort ur trädet.
     *
     * @return en referens till nodens subträd efter borttaget.
     */
    public BinarySearchTreeNode<T> remove(T data) {
        return null;
    }

    /**
     * Kontrollerar om ett givet element finns i det (sub)träd som noden utgör
     * root i.
     *
     * @param data det sökta elementet.
     *
     * @return true om det sökta elementet finns i det (sub)träd som noden utgör
     *         root i.
     */
    public boolean contains(T data) {
        return false;
    }

    /**
     * Storleken på det (sub)träd som noden utgör root i.
     *
     * @return det totala antalet noder i det (sub)träd som noden utgör root i.
     */
    public int size() {
        return 0;
    }

    /**
     * Det högsta djupet i det (sub)träd som noden utgör root i.
     *
     * @return djupet.
     */
    public int depth() {
        return -1;
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
