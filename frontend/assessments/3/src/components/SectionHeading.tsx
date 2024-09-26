
interface SectionHeadingProps{
    name: string;
}
const styles: { [key: string]: React.CSSProperties } = {
    sectionHeading: {
        width: "100%",
        backgroundColor: "#f08a5d",
        color: "#fff",
        padding: "10px 25px",
        fontSize: "0.7rem",
        marginBottom:"1rem"
    },

  };
function SectionHeading({ name } : SectionHeadingProps) {
    return (
        <div className="sectionHeading"style={styles.sectionHeading}>{name}</div>
      );
}

export default SectionHeading;