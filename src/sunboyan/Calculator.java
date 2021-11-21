package sunboyan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.*;
import java.awt.SystemColor;
import javax.swing.UIManager;
public class Calculator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	BigDecimal result=new BigDecimal(0);
	String resultString=new String("0");
	BigDecimal inNum=new BigDecimal(0);
	StringBuilder inString=new StringBuilder("0");
	BigDecimal perTemp=new BigDecimal(0);
	char operatorString=' ';
	boolean equaled=false;
	boolean dotted=false;	
	boolean computed=false;
	private JPanel contentPane;
	public JLabel myResultLabel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Calculator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 334, 442);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(2, 3, 2, 3));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel downPanel = new JPanel();
		downPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(downPanel, BorderLayout.CENTER);
		downPanel.setLayout(new GridLayout(6, 4, 0, 0));
		
		JButton percentButton = new JButton("%");
		percentButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		percentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(equaled) {
					System.out.println(perTemp);
					System.out.println(inNum);
					System.out.println(result);
						if (computed) {
							if (operatorString == '+' || operatorString == '-') {
								perTemp=result;
								result=result.multiply(perTemp).divide(new BigDecimal("100.0"),10,RoundingMode.HALF_UP);
								computed=false;
							} else {
								result = result.divide(new BigDecimal("100.0"), 10, RoundingMode.HALF_UP);
							}
							result.setScale(10, RoundingMode.HALF_UP);
							if (result.compareTo(new BigDecimal(result.intValue())) == 0) {
								resultString = String.valueOf(result.intValue());
							} else {
								resultString = result.stripTrailingZeros().toString();
							}
							inString.delete(0, inString.length());
							if (resultString.length() < 14) {
								myResultLabel.setText(resultString.toString());
							} else {
								myResultLabel.setText(resultString.toString().substring(0, 14));
							} 
						} else {
							if (operatorString == '+' || operatorString == '-') {
								result=result.multiply(perTemp).divide(new BigDecimal("100.0"),10,RoundingMode.HALF_UP);
							} else {
								result = result.divide(new BigDecimal("100.0"), 10, RoundingMode.HALF_UP);
							}
							result.setScale(10, RoundingMode.HALF_UP);
							if (result.compareTo(new BigDecimal(result.intValue())) == 0) {
								resultString = String.valueOf(result.intValue());
							} else {
								resultString = result.stripTrailingZeros().toString();
							}
							inString.delete(0, inString.length());
							if (resultString.length() < 14) {
								myResultLabel.setText(resultString.toString());
							} else {
								myResultLabel.setText(resultString.toString().substring(0, 14));
							} 
						}
				}else {
					if (computed) {
						if (operatorString=='+'||operatorString=='-') {
							System.out.println(4);
							result = perTemp.multiply(result).divide(new BigDecimal("100.0"), 10, RoundingMode.HALF_UP);
						}else {
							inNum = result.divide(new BigDecimal("100.0"), 10, RoundingMode.HALF_UP);
						}
						result.setScale(10, RoundingMode.HALF_UP);
						if (result.compareTo(new BigDecimal(result.intValue())) == 0) {
							resultString = String.valueOf(result.intValue());
						} else {
							resultString = result.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}else {
						if (operatorString=='+'||operatorString=='-') {
							System.out.println(5);
							inNum = inNum.multiply(result).divide(new BigDecimal("100.0"), 10,
									RoundingMode.HALF_UP);
						}else {
							inNum = inNum.divide(new BigDecimal("100.0"), 10,
									RoundingMode.HALF_UP);
						}
						result.setScale(10, RoundingMode.HALF_UP);
						if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						}
					}
				}
				computed=false;
			}
		});
		downPanel.add(percentButton);
		
		JButton clearButton = new JButton("C");
		clearButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				equaled=false;
				inNum=new BigDecimal("0");
				result=new BigDecimal("0");
				inString.replace(0,inString.length(),"0");
				resultString="0";
				dotted=false;
				operatorString=' ';
				myResultLabel.setText("0");
			}
		});
		downPanel.add(clearButton);
		
		JButton cClearButton = new JButton("CE");
		cClearButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		cClearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				if(equaled) {
					inString.delete(0, inString.length());
					myResultLabel.setText("0");
					result = new BigDecimal("0");
					dotted=false;
				}else {
					inString.delete(0, inString.length());
					myResultLabel.setText("0");
					inNum=new BigDecimal("0");
					dotted=false;
				}		
			}
		});
		downPanel.add(cClearButton);
		
		JButton backButton = new JButton("DEL");
		backButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(equaled) {
					;
				}else {
					if(inString.length()>1) {
						if(inString.charAt(inString.length()-1)=='.')
						{
							inString.delete(inString.length()-1, inString.length());
						}
						inString.delete(inString.length()-1, inString.length());
						inNum=new BigDecimal(inString.toString());
						if(inNum.compareTo(new BigDecimal(inNum.intValue()))==0){
							resultString=String.valueOf(inNum.intValue());
						}else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						if (resultString.length()<14) {
							myResultLabel.setText(resultString.toString());
						}else {
							myResultLabel.setText(resultString.toString().substring(0,14));
						}
					}else {
						inString.replace(0, 1, "0");
						inNum=new BigDecimal(inString.toString());
						if(inNum.compareTo(new BigDecimal(inNum.intValue()))==0){
							resultString=String.valueOf(inNum.intValue());
						}else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						if (resultString.length()<14) {
							myResultLabel.setText(resultString.toString());
						}else {
							myResultLabel.setText(resultString.toString().substring(0,14));
						}
					}
				}
			}
		});
		downPanel.add(backButton);
		
		JButton dButton = new JButton("1/x");
		dButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		dButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(equaled) {
					if(result.equals(new BigDecimal("0"))) {
						resultString="Infinity";
						//pause
					}else {
						perTemp=new BigDecimal(result.toString());
						result = new BigDecimal("1").divide(result,10, RoundingMode.HALF_DOWN);
						result.setScale(10,RoundingMode.HALF_UP);
						if(result.compareTo(new BigDecimal(result.intValue()))==0){
							resultString=String.valueOf(result.intValue());
						}else {
							resultString = result.stripTrailingZeros().toString();
						}
					}
					computed=true;
					inString.delete(0, inString.length());
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					if (computed) {
						if (inNum.equals(new BigDecimal("0"))) {
							resultString = "Infinity";
							//pause
						} else {
							perTemp=new BigDecimal(result.toString());
							inNum = new BigDecimal("1").divide(result, 10, RoundingMode.HALF_DOWN);
							inNum.setScale(10, RoundingMode.HALF_UP);
							if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
								resultString = String.valueOf(inNum.intValue());
							} else {
								resultString = inNum.stripTrailingZeros().toString();
							}
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}else {
						if (inNum.equals(new BigDecimal("0"))) {
							resultString = "Infinity";
							backButton.setEnabled(false);
						} else {
							perTemp=new BigDecimal(inNum.toString());
							inNum = new BigDecimal("1").divide(inNum, 10, RoundingMode.HALF_DOWN);
							inNum.setScale(10, RoundingMode.HALF_UP);
							if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
								resultString = String.valueOf(inNum.intValue());
							} else {
								resultString = inNum.stripTrailingZeros().toString();
							}
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}
				}
			computed=false;	
			}
		});
		downPanel.add(dButton);		
		JButton squareButton = new JButton("sqrt");
		squareButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		squareButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(equaled) {
					try {
						perTemp=new BigDecimal(result.toString());
						result = result.sqrt(MathContext.DECIMAL64);
					} catch (Exception e2) {
						myResultLabel.setText("Error");
						return;
					}
					result.setScale(10, RoundingMode.HALF_UP);
					if(result.compareTo(new BigDecimal(result.intValue()))==0){
						resultString=String.valueOf(result.intValue());
					}else {
						resultString = result.stripTrailingZeros().toString();
					}
					inString.delete(0, inString.length());
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					if (computed) {
						try {
							perTemp=new BigDecimal(result.toString());
							inNum = result.sqrt(MathContext.DECIMAL64);
						} catch (Exception e2) {
							myResultLabel.setText("Error");
							return;
						}
						result.setScale(10, RoundingMode.HALF_UP);
						if (inNum.compareTo(new BigDecimal(result.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}else {
						try {
							perTemp=new BigDecimal(inNum.toString());
							inNum = inNum.sqrt(MathContext.DECIMAL64);
						} catch (Exception e2) {
							myResultLabel.setText("Error");
							return;
						}
						result.setScale(10, RoundingMode.HALF_UP);
						if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}
				}
				computed=false;	
			}
			
		});
		downPanel.add(squareButton);
		
		JButton sqrtButton = new JButton("sqr");
		sqrtButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		sqrtButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(equaled) {
					perTemp=new BigDecimal(result.toString());
					result=result.pow(2);
					result.setScale(10, RoundingMode.HALF_UP);
					if(result.compareTo(new BigDecimal(result.intValue()))==0){
						resultString=String.valueOf(result.intValue());
					}else {
						resultString = result.stripTrailingZeros().toString();
					}
					inString.delete(0, inString.length());
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					if (computed) {
						perTemp=new BigDecimal(result.toString());
						inNum = result.pow(2);
						result.setScale(10, RoundingMode.HALF_UP);
						if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}else {
						perTemp=new BigDecimal(inNum.toString());
						inNum = inNum.pow(2);
						result.setScale(10, RoundingMode.HALF_UP);
						if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						}
					}
				}	
				computed=false;	
			}
		});
		downPanel.add(sqrtButton);
		
		JButton divideButton = new JButton("/");
		divideButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		divideButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				if(equaled) {
					inNum = new BigDecimal(result.toString());
					inString.delete(0, inString.length());
					operatorString='/';
					equaled=false;
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					compute();
					inString.delete(0, inString.length());
					operatorString='/';
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}		
			}
		});
		downPanel.add(divideButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		sevenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('7');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length() < 14) {
						myResultLabel.setText(inString.toString());
				} 
			}
		
		});
		downPanel.add(sevenButton);
		
		JButton eightButton = new JButton("8");
		eightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('8');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		downPanel.add(eightButton);
		eightButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JButton nineButton = new JButton("9");
		nineButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('9');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}			
			}
		
		});
		nineButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(nineButton);
		
		JButton multiButton = new JButton("X");
		multiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				if(equaled) {
					inNum = new BigDecimal(result.toString());
					System.out.println("11");
					inString.delete(0, inString.length());
					operatorString='*';
					equaled=false;
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					compute();
					inString.delete(0, inString.length());
					operatorString='*';
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}
			}
		});
		multiButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(multiButton);
		
		JButton fourButton = new JButton("4");
		fourButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('4');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		fourButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(fourButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('5');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		fiveButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('6');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		sixButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(sixButton);
		
		JButton minusButton = new JButton("-");
		minusButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				if(equaled) {
					inNum = new BigDecimal(result.toString());
					inString.delete(0, inString.length());
					operatorString='-';
					equaled=false;
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					compute();
					inString.delete(0, inString.length());
					operatorString='-';
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}
			}
		});
		minusButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		downPanel.add(minusButton);
		
		JButton oneButton = new JButton("1");
		oneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('1');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		oneButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('2');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		twoButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(twoButton);
		
		JButton threeButton = new JButton("3");
		threeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('3');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		
		});
		threeButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(threeButton);
		
		
		JButton addButton = new JButton("+");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				if(equaled) {
					inNum = new BigDecimal(result.toString());
					inString.delete(0, inString.length());
					operatorString='+';
					equaled=false;
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					compute();
					inString.delete(0, inString.length());
					operatorString='+';
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}
			}
		});
		addButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		downPanel.add(addButton);
		
		JButton oppoButton = new JButton("+/-");
		oppoButton.setSelectedIcon(null);
		oppoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(equaled) {
					perTemp=new BigDecimal(result.toString());
					result=result.negate();
					result.setScale(10,RoundingMode.HALF_UP);
					if(result.compareTo(new BigDecimal(result.intValue()))==0){
						resultString=String.valueOf(result.intValue());
					}else {
						resultString = result.stripTrailingZeros().toString();
					}
					inString.delete(0, inString.length());
					if (resultString.length()<14) {
						myResultLabel.setText(resultString.toString());
					}else {
						myResultLabel.setText(resultString.toString().substring(0,14));
					}
				}else {
					if (computed) {
						perTemp=new BigDecimal(result.toString());
						inNum = result.negate();
						result.setScale(10, RoundingMode.HALF_UP);
						if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						} 
					}else {
						perTemp=new BigDecimal(inNum.toString());
						inNum = inNum.negate();
						if (inNum.compareTo(new BigDecimal(inNum.intValue())) == 0) {
							resultString = String.valueOf(inNum.intValue());
						} else {
							resultString = inNum.stripTrailingZeros().toString();
						}
						inString.delete(0, inString.length());
						if (resultString.length() < 14) {
							myResultLabel.setText(resultString.toString());
						} else {
							myResultLabel.setText(resultString.toString().substring(0, 14));
						}
					}	
				}	
				computed=false;	
			}
		});
		oppoButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		downPanel.add(oppoButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.setSelectedIcon(null);
		zeroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				computed=false;
				if(inString.length()==1&&inString.charAt(0)=='0') {
					inString.delete(0, 1);
				}
				inString.append('0');
				if (equaled) {
					result = new BigDecimal(inString.toString());		
				} else {
					inNum=new BigDecimal(inString.toString());
				}
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		});
		zeroButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		downPanel.add(zeroButton);
		JButton dotButton = new JButton(".");
		dotButton.setSelectedIcon(null);
		dotButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perTemp=new BigDecimal("0");
				if(dotted) {
					return;
				}
				if(inString.isEmpty()) {
					inString.append("0");
				}dotted=true;
				inString.append('.');
				inNum=new BigDecimal(inString.toString());
				if (inString.length()<14) {
					myResultLabel.setText(inString.toString());
				}
			}
		});
		dotButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		downPanel.add(dotButton);
		
		JButton equalButton = new JButton("=");
		equalButton.setBackground(SystemColor.activeCaption);
		equalButton.setSelectedIcon(null);
		equalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (computed) {
					perTemp = new BigDecimal("0");
					compute();
					equaled = true;
					inString.delete(0, inString.length());
					if (resultString.length() < 14) {
						myResultLabel.setText(resultString.toString());
					} else {
						myResultLabel.setText(resultString.toString().substring(0, 14));
					} 
				}else {
					perTemp = new BigDecimal("0");
					compute();
					computed=true;
					equaled = true;
					inString.delete(0, inString.length());
					if (resultString.length() < 14) {
						myResultLabel.setText(resultString.toString());
					} else {
						myResultLabel.setText(resultString.toString().substring(0, 14));
					} 
				}
			}
		});
		equalButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 26));
		downPanel.add(equalButton);
		
		JPanel upPanel = new JPanel();
		contentPane.add(upPanel, BorderLayout.NORTH);
		upPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel blankLabel = new JLabel(" ");
		blankLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		upPanel.add(blankLabel, BorderLayout.NORTH);
		
		JLabel resultLabel = new JLabel("0");
		resultLabel.setFont(new Font("Î¢Ü›ÕýºÚów", Font.BOLD, 38));
		myResultLabel=resultLabel;
		resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);	
		upPanel.add(resultLabel, BorderLayout.CENTER);
		
		JLabel BlankLabel1 = new JLabel(" ");
		BlankLabel1.setFont(new Font("ËÎÌå", Font.PLAIN, 10));
		upPanel.add(BlankLabel1, BorderLayout.SOUTH);
	}
	public void compute() {
		switch(operatorString) {
		case '+':
			result=result.add(inNum);
			result.setScale(10,RoundingMode.HALF_UP);
			if(result.compareTo(new BigDecimal(result.intValue()))==0){
				resultString=String.valueOf(result.intValue());
			}else {
				resultString = result.stripTrailingZeros().toString();
			}
			break;
		case '-':
			result=result.subtract(inNum);
			result.setScale(10,RoundingMode.HALF_UP);
			if(result.compareTo(new BigDecimal(result.intValue()))==0){
				resultString=String.valueOf(result.intValue());
			}else {
				resultString = result.stripTrailingZeros().toString();
			}
			break;
		case '*':
			System.out.println(inNum);
			System.out.println(result);
			result=result.multiply(inNum);
			result.setScale(10,RoundingMode.HALF_UP);
			if(result.compareTo(new BigDecimal(result.intValue()))==0){
				resultString=String.valueOf(result.intValue());
			}else {
				resultString = result.stripTrailingZeros().toString();
			}
			break;
		case '/':
			if(inNum.equals(new BigDecimal("0"))) {
				resultString="Infinity";
				//pause
			}else {
				result = result.divide(inNum,10,RoundingMode.HALF_DOWN);
				result.setScale(10,RoundingMode.HALF_UP);
				if(result.compareTo(new BigDecimal(result.intValue()))==0){
					resultString=String.valueOf(result.intValue());
				}else {
					resultString = result.stripTrailingZeros().toString();
				}
			}
			break;
		case '|':
			BigDecimal zeroBigDecimal= new BigDecimal("0");
			result=zeroBigDecimal.subtract(inNum);
			inNum=result;
			result.setScale(10,RoundingMode.HALF_UP);
			if(result.compareTo(new BigDecimal(result.intValue()))==0){
				resultString=String.valueOf(result.intValue());
			}else {
				resultString = result.stripTrailingZeros().toString();
			}
			break;
		case ' ':
			result=new BigDecimal(inString.toString());
			result.setScale(10,RoundingMode.HALF_UP);
			if(result.compareTo(new BigDecimal(result.intValue()))==0){
				resultString=String.valueOf(result.intValue());
			}else {
				resultString = result.stripTrailingZeros().toString();
			}
			break;
		default:
			equaled=false;
			dotted=false;
			computed=true;
		}
	}
}
