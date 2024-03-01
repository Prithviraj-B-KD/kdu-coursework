interface OptionButtonProps{
    name: string;
}
const styles: { [key: string]: React.CSSProperties } = {
    optionButton: {
        cursor:"pointer",
        color: "#333",
        padding: "15px 30px",
        fontSize: "0.5rem",
        border: "1px solid black",
        backgroundColor:"white"
    },
    
  };
function OptionButton({ name } : OptionButtonProps) {
    return (
        <button className="optionButton"style={styles.optionButton}>{name}</button>
      );
}

export default OptionButton;